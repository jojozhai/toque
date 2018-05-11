/*
 * 项目名称：toque-core
 * 类名称: StatisticsServiceImpl.java
 * 创建时间: 2018年1月5日 下午6:39:26
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.proginn.toque.domain.Statistics;
import com.proginn.toque.dto.ChartInfo;
import com.proginn.toque.dto.StatisticsCondition;
import com.proginn.toque.dto.StatisticsResult;
import com.proginn.toque.repository.StatisticsRepository;
import com.proginn.toque.service.StatisticsService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	private StatisticsRepository statisticsRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.StatisticsService#statisticsNewUser(com.proginn.toque.dto.StatisticsCondition)
	 */
	@Override
	public StatisticsResult statisticsNewUser(StatisticsCondition condition) {
		
		checkDate(condition);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		
		List<Statistics> statisticses = statisticsRepository.findByDateBetween(condition.getStartTime(), condition.getEndTime(), new Sort(Direction.ASC, "date"));
		
		StatisticsResult result = new StatisticsResult(new ChartInfo("新用户", 
				statisticses.stream().map(stat -> dateFormat.format(stat.getDate())).collect(Collectors.toList()), 
				statisticses.stream().map(Statistics::getRegistCount).collect(Collectors.toList())));
		
		result.setNewUserCount(statisticses.stream().mapToInt(Statistics::getRegistCount).sum());
		result.setActiveUserCount(statisticses.stream().mapToInt(Statistics::getActiveCount).sum());
		
		return result;
	}

	@Override
	public StatisticsResult statisticsActiveUser(StatisticsCondition condition) {
		
		checkDate(condition);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		
		List<Statistics> statisticses = statisticsRepository.findByDateBetween(condition.getStartTime(), condition.getEndTime(), new Sort(Direction.ASC, "date"));
		
		Function<Statistics, Integer> function = Statistics::getActiveCount;
		if(StringUtils.equals(condition.getStatUnit(), "week")) {
			function = Statistics::getActiveCountForWeek;
		}else if(StringUtils.equals(condition.getStatUnit(), "month")) {
			function = Statistics::getActiveCountForMonth;
		}
		
		StatisticsResult result = new StatisticsResult(new ChartInfo("活跃用户", 
				statisticses.stream().map(stat -> dateFormat.format(stat.getDate())).collect(Collectors.toList()), 
				statisticses.stream().map(function).collect(Collectors.toList())));
		
		return result;
	}
	


	@Override
	public StatisticsResult statisticsPayUser(StatisticsCondition condition) {
		
		checkDate(condition);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		
		List<Statistics> statisticses = statisticsRepository.findByDateBetween(condition.getStartTime(), condition.getEndTime(), new Sort(Direction.ASC, "date"));
		
		StatisticsResult result = new StatisticsResult(new ChartInfo("付费用户", 
				statisticses.stream().map(stat -> dateFormat.format(stat.getDate())).collect(Collectors.toList()), 
				statisticses.stream().map(Statistics::getPayCount).collect(Collectors.toList())));
		
		return result;
		
	}

	private void checkDate(StatisticsCondition condition) {
		if(condition.getStartTime() == null) {
			throw new RuntimeException("开始时间不能为空");
		}
		
		if(condition.getEndTime() == null) {
			throw new RuntimeException("结束时间不能为空");
		}
		
		if(condition.getStartTime().after(condition.getEndTime())) {
			throw new RuntimeException("开始时间不能在结束时间之后");
		}
		
		if(new DateTime(condition.getStartTime()).plusMonths(1).isBefore(new DateTime(condition.getEndTime()))) {
			throw new RuntimeException("查询时间间隔不能超过30天");
		}
	}

}
