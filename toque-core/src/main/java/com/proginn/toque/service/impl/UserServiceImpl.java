/*
 * 项目名称：toque-core
 * 类名称: UserServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:02:46
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.RestaurantLevel;
import com.proginn.toque.domain.User;
import com.proginn.toque.domain.UserType;
import com.proginn.toque.dto.FirstPageInfo;
import com.proginn.toque.dto.UserCondition;
import com.proginn.toque.dto.UserInfo;
import com.proginn.toque.dto.UserStaticticsCondition;
import com.proginn.toque.dto.UserStaticticsEnum;
import com.proginn.toque.repository.LessonAssignHistoryRepository;
import com.proginn.toque.repository.LessonPlayRepository;
import com.proginn.toque.repository.RestaurantLevelHistoryRepository;
import com.proginn.toque.repository.UserRepository;
import com.proginn.toque.repository.spec.UserSpec;
import com.proginn.toque.repository.spec.UserStatisticsForIndexSpec;
import com.proginn.toque.service.UserService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LessonPlayRepository lessonPlayRepository;
	
	@Autowired
	private LessonAssignHistoryRepository lessonAssignHistoryRepository;
	
	@Autowired
	private RestaurantLevelHistoryRepository restaurantLevelHistoryRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#create(com.proginn.toque.dto.UserInfo)
	 */
	@Override
	public UserInfo create(UserInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#update(com.proginn.toque.dto.UserInfo)
	 */
	@Override
	public UserInfo update(UserInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#query(com.proginn.toque.dto.UserCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<UserInfo> query(UserCondition condition, Pageable pageable) {
		Page<User> users = userRepository.findAll(new UserSpec(condition), pageable);
		return QueryResultConverter.convert(users, pageable, (user) -> {
			return user.toUserInfo(jdbcTemplate.queryForList("select distinct(a.imooc_lesson_imooc_id) from imooc_lessonassign a " + 
					"left join imooc_lesson b on a.imooc_lesson_imooc_id=b.imooc_id " + 
					"left join imooc_trainingbox c on b.imooc_module_imooc_id=c.imooc_mid " + 
					" where c.imooc_uid= "+user.getId()+" and imooc_required = 1").size());
		});
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#get(java.lang.Long)
	 */
	@Override
	public UserInfo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.UserService#statistics()
	 */
	@Override
	public FirstPageInfo statisticsIndex() {
		FirstPageInfo stat = new FirstPageInfo();
		
		Date today = new DateTime().withTimeAtStartOfDay().toDate();
		//Toque应用今日数据概况
		//新用户
		stat.setNewUser(userRepository.count(new UserStatisticsForIndexSpec(new UserStaticticsCondition(UserStaticticsEnum.NEW))));
		stat.setNewUserChef(userRepository.count(new UserStatisticsForIndexSpec(new UserStaticticsCondition(UserStaticticsEnum.NEW, UserType.CHEF))));
		stat.setNewUserTrainee(stat.getNewUser() - stat.getNewUserChef());
		//活跃用户
		stat.setActiveUser(userRepository.count(new UserStatisticsForIndexSpec(new UserStaticticsCondition(UserStaticticsEnum.ACTIVE))));
		stat.setActiveUserChef(userRepository.count(new UserStatisticsForIndexSpec(new UserStaticticsCondition(UserStaticticsEnum.ACTIVE, UserType.CHEF))));
		stat.setActiveUserTrainee(stat.getActiveUser() - stat.getActiveUserChef());
		//新付费用户
		stat.setPayUserVip2(restaurantLevelHistoryRepository.countByLevel(RestaurantLevel.VIP2, today));
		stat.setPayUserVip3(restaurantLevelHistoryRepository.countByLevel(RestaurantLevel.VIP3, today));
		stat.setPayUserVip4(restaurantLevelHistoryRepository.countByLevel(RestaurantLevel.VIP4, today));
		stat.setPayUser(stat.getPayUserVip2() + stat.getPayUserVip3() + stat.getPayUserVip4());
		//播放次数
		stat.setPlayToday(lessonPlayRepository.countPlayPv(today));
		
		// Toque应用近7日数据概况
		Date weekAgo = new DateTime().withTimeAtStartOfDay().plusDays(-7).toDate();
		stat.setAvgTimeWeek(computAvgTimeWeek(weekAgo));
		stat.setAvgAssignWeek(computAvgAssignWeek(weekAgo));
//		stat.setKinchenPv(kinchenPv);
		
		//Toque应用累计数据概况
		Date centuryAgo = new DateTime().plusYears(-100).toDate();
		stat.setAllUser(userRepository.count());
		stat.setAllPayUser(restaurantLevelHistoryRepository.countByDate(centuryAgo));
		
		long playPv = lessonPlayRepository.countPlayPv(centuryAgo);
		long playUv = lessonPlayRepository.countPlayUv(centuryAgo);
		long avgPlay = 0;
		if(playUv != 0) {
			avgPlay = playPv / playUv;
		}
		stat.setAvgPlayTotal(avgPlay);
		stat.setCountPlayTotal(playPv);
		
		return stat;
	}

	/**
	 * @param weekAgo
	 * @return
	 */
	private long computAvgAssignWeek(Date weekAgo) {
		long assignUvWeek = lessonAssignHistoryRepository.countUv(weekAgo);
		long avgAssignWeek = 0;
		if(assignUvWeek != 0) {
			long assignPvWeek = lessonAssignHistoryRepository.countPv(weekAgo);
			avgAssignWeek = assignPvWeek / assignUvWeek;
		}
		return avgAssignWeek;
	}

	/**
	 * @param weekAgo
	 * @return
	 */
	private String computAvgTimeWeek(Date weekAgo) {
		long playPvWeek = lessonPlayRepository.countPlayPv(weekAgo);
		String avgTimeWeek;
		if(playPvWeek == 0) {
			avgTimeWeek = "0分0秒";
		}else {
			long sumTimeWeek = lessonPlayRepository.sumPlayTime(weekAgo);
			long avgTime = sumTimeWeek / playPvWeek;
			long minutes = avgTime / 60;
			long seconds = avgTime - 60 * minutes;
			avgTimeWeek = minutes + "分" + seconds + "秒";
		}
		return avgTimeWeek;
	}

}
