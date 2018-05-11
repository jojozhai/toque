/*
 * 项目名称：toque-core
 * 类名称: LessonStatServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:02:46
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.LessonStat;
import com.proginn.toque.dto.LessonStatCondition;
import com.proginn.toque.dto.LessonStatInfo;
import com.proginn.toque.repository.LessonStatRepository;
import com.proginn.toque.repository.spec.LessonStatSpec;
import com.proginn.toque.service.LessonStatService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class LessonStatServiceImpl implements LessonStatService {

	@Autowired
	private LessonStatRepository lessonStatRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proginn.toque.service.LessonStatService#create(com.proginn.toque.dto.
	 * LessonStatInfo)
	 */
	@Override
	public LessonStatInfo create(LessonStatInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proginn.toque.service.LessonStatService#update(com.proginn.toque.dto.
	 * LessonStatInfo)
	 */
	@Override
	public LessonStatInfo update(LessonStatInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proginn.toque.service.LessonStatService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proginn.toque.service.LessonStatService#query(com.proginn.toque.dto.
	 * LessonStatCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<LessonStatInfo> query(LessonStatCondition condition, Pageable pageable) {
		Page<LessonStat> lessonStats = lessonStatRepository.findAll(new LessonStatSpec(condition), pageable);
		return QueryResultConverter.convert(lessonStats, pageable, (lessonStat) -> {
			LessonStatInfo info = new LessonStatInfo();

			info.setLessonTitle(lessonStat.getLesson().getTitle());
			info.setLessonTitleE(lessonStat.getLesson().getTitleE());

			Long playPv = null;
			Long playUv = null;
			String avgTime = null;
			Long finished = null;
			Long assigned = null;
			Long praised = null;
			Long criticism = null;

			if (StringUtils.equals("yesterday", condition.getScope())) {

				playPv = lessonStat.getPlayPv();
				playUv = lessonStat.getPlayUv();
				avgTime = buildAvgTime(lessonStat.getAvgTime());
				finished = lessonStat.getFinished();
				assigned = lessonStat.getAssigned();
				praised = lessonStat.getPraised();
				criticism = lessonStat.getCriticism();

			}else if (StringUtils.equals("week", condition.getScope())) {

				playPv = lessonStat.getPlayPvWeek();
				playUv = lessonStat.getPlayUvWeek();
				avgTime = buildAvgTime(lessonStat.getAvgTimeWeek());
				finished = lessonStat.getFinishedWeek();
				assigned = lessonStat.getAssignedWeek();
				praised = lessonStat.getPraisedWeek();
				criticism = lessonStat.getCriticismWeek();

			}else {
				
				playPv = lessonStat.getPlayPvTotal();
				playUv = lessonStat.getPlayUvTotal();
				avgTime = buildAvgTime(lessonStat.getAvgTimeTotal());
				finished = lessonStat.getFinishedTotal();
				assigned = lessonStat.getAssignedTotal();
				praised = lessonStat.getPraisedTotal();
				criticism = lessonStat.getCriticismTotal();
			}
			
			info.setPlayPv(playPv);
			info.setPlayUv(playUv);
			info.setAvgTime(avgTime);
			info.setFinished(finished);
			info.setAssigned(assigned);
			info.setPraised(praised);
			info.setCriticism(criticism);

			return info;
		});
	}

	/**
	 * @param avgTime
	 * @return
	 */
	private String buildAvgTime(BigDecimal avgTime) {
		int minutes = avgTime.intValue() / 60;
		int seconds = avgTime.intValue() - 60 * minutes;
		return minutes + "分" + seconds + "秒";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proginn.toque.service.LessonStatService#get(java.lang.Long)
	 */
	@Override
	public LessonStatInfo get(Long id) {
		return null;
	}

}
