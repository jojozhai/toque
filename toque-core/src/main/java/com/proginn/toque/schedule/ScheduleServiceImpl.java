/**
 * 
 */
package com.proginn.toque.schedule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.proginn.toque.domain.Lesson;
import com.proginn.toque.domain.LessonStat;
import com.proginn.toque.domain.Statistics;
import com.proginn.toque.domain.Template;
import com.proginn.toque.repository.LessonAssignRepository;
import com.proginn.toque.repository.LessonPlayRepository;
import com.proginn.toque.repository.LessonRepository;
import com.proginn.toque.repository.LessonStatRepository;
import com.proginn.toque.repository.PraiseRepository;
import com.proginn.toque.repository.RestaurantLevelHistoryRepository;
import com.proginn.toque.repository.StatisticsRepository;
import com.proginn.toque.repository.TemplateRepository;
import com.proginn.toque.repository.UserRepository;

/**
 * @author zhailiang
 *
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService, InitializingBean, ApplicationContextAware {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	
	private ApplicationContext applicationContext;
	
	@Value("${toque.schedule.master.ip:172.31.15.124}")
	private String masterIp;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private LessonPlayRepository lessonPlayRepository;

	@Autowired
	private LessonStatRepository lessonStatRepository;
	
	@Autowired
	private LessonAssignRepository lessonAssignRepository;
	
	@Autowired
	private PraiseRepository praiseRepository;
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private StatisticsRepository statisticsRepository;
	
	@Autowired
	private RestaurantLevelHistoryRepository restaurantLevelHistoryRepository;
	
	@Autowired
	private MessageSender messageSender;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
//		dailyStatistics();
	}

	@Override
	@Scheduled(cron = "1 0 0 * * ?")
	public void dailyStatistics() throws Exception {
		
		if(!isProd() || isMaster()) {
			Date startOfDay = new DateTime().withTimeAtStartOfDay().plusDays(-1).toDate();
			Date startOfWeek = new DateTime(startOfDay).plusWeeks(-1).toDate();
			Date startOfMonth = new DateTime(startOfDay).plusMonths(-1).toDate();
			
			Statistics statistics = new Statistics();
			statistics.setDate(startOfDay);
			statistics.setRegistCount(userRepository.countByRegistTime(startOfDay));
			statistics.setActiveCount(userRepository.countByLastLoginTime2(startOfDay));
			statistics.setActiveCountForWeek(userRepository.countByLastLoginTime2(startOfWeek));
			statistics.setActiveCountForMonth(userRepository.countByLastLoginTime2(startOfMonth));
			statistics.setPayCount(restaurantLevelHistoryRepository.countByDate(startOfDay));
			statisticsRepository.save(statistics);
			
			Date totalStartTime = new DateTime(startOfDay).plusYears(-100).toDate();
			lessonRepository.findAll().forEach(lesson -> {
				
				LessonStat lessonStat = new LessonStat();
				lessonStat.setDate(startOfDay);
				lessonStat.setLesson(lesson);
				
				lessonStat.setPlayPv(lessonPlayRepository.countPlayPv(lesson, startOfDay));
				lessonStat.setPlayUv(lessonPlayRepository.countPlayUv(lesson, startOfDay));
				
				lessonStat.setAvgTime(computeAvgTime(startOfDay, lesson, lessonStat.getPlayPv()));
				lessonStat.setFinished(lessonPlayRepository.countFinished(lesson, startOfDay, true));
				lessonStat.setAssigned(lessonAssignRepository.countByLesson(lesson, startOfDay));
				lessonStat.setPraised(praiseRepository.countByLesson(lesson, startOfDay, true));
				lessonStat.setCriticism(praiseRepository.countByLesson(lesson, startOfDay, false));
				
				lessonStat.setPlayPvWeek(lessonPlayRepository.countPlayPv(lesson, startOfWeek));
				lessonStat.setPlayUvWeek(lessonPlayRepository.countPlayUv(lesson, startOfWeek));
				lessonStat.setAvgTimeWeek(computeAvgTime(startOfWeek, lesson, lessonStat.getPlayPvWeek()));
				lessonStat.setFinishedWeek(lessonPlayRepository.countFinished(lesson, startOfWeek, true));
				lessonStat.setAssignedWeek(lessonAssignRepository.countByLesson(lesson, startOfWeek));
				lessonStat.setPraisedWeek(praiseRepository.countByLesson(lesson, startOfWeek, true));
				lessonStat.setCriticismWeek(praiseRepository.countByLesson(lesson, startOfWeek, false));
				
				lessonStat.setPlayPvTotal(lessonPlayRepository.countPlayPv(lesson, totalStartTime));
				lessonStat.setPlayUvTotal(lessonPlayRepository.countPlayUv(lesson, totalStartTime));
				lessonStat.setAvgTimeTotal(computeAvgTime(totalStartTime, lesson, lessonStat.getPlayPvTotal()));
				lessonStat.setFinishedTotal(lessonPlayRepository.countFinished(lesson, totalStartTime, true));
				lessonStat.setAssignedTotal(lessonAssignRepository.countByLesson(lesson, totalStartTime));
				lessonStat.setPraisedTotal(praiseRepository.countByLesson(lesson, totalStartTime, true));
				lessonStat.setCriticismTotal(praiseRepository.countByLesson(lesson, totalStartTime, false));
				
				lessonStatRepository.save(lessonStat);
			});
		}
		
		
	}

	/**
	 * @return
	 */
	private boolean isProd() {
		return ArrayUtils.contains(applicationContext.getEnvironment().getActiveProfiles(), "prod") ;
	}

	/**
	 * @return
	 * @throws SocketException 
	 * @throws UnknownHostException 
	 */
	@SuppressWarnings("rawtypes")
	public boolean isMaster() throws SocketException, UnknownHostException {
		Set<String> ipList = new HashSet<>();
        for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
            NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
            for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                if (!inetAddr.isLoopbackAddress()
                        && inetAddr.getHostAddress().matches(
                        "(\\d{1,3}\\.){3}\\d{1,3}")) {
                    ipList.add(inetAddr.getHostAddress());
                }
            }
        }
		return ipList.contains(masterIp);
	}
	
	/**
	 * @param startOfDay
	 * @param lesson
	 * @param lessonStat
	 * @return
	 */
	private BigDecimal computeAvgTime(Date start, Lesson lesson, Long playPv) {
		log.info("date: "+DateFormatUtils.format(start, "yyyy-MM-dd"));
		log.info("playPv: "+playPv);
		BigDecimal avgTime = BigDecimal.ZERO;
		if(playPv != 0) {
			long sumTime = lessonPlayRepository.sumPlayTime(lesson, start);
			log.info("sumTime: "+sumTime);
			avgTime = new BigDecimal(sumTime).divide(new BigDecimal(playPv), 2, RoundingMode.HALF_UP);
		}
		return avgTime;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.schedule.ScheduleService#sendMessage()
	 */
	@Override
	@Scheduled(cron = "0 */1 * * * ?")
	public void sendMessage() {
		List<Template> templates = templateRepository.findByImmediatelyAndProcessed(false, false);
		templates.stream().forEach(template -> {
			messageSender.send(template);
			template.setProcessed(true);
			templateRepository.save(template);
		});
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
