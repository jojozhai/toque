/*
 * 项目名称：toque-core
 * 类名称: StatisticsService.java
 * 创建时间: 2018年1月5日 下午6:33:52
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service;

import com.proginn.toque.dto.StatisticsCondition;
import com.proginn.toque.dto.StatisticsResult;

/**
 * @author zhailiang@jd.com
 *
 */
public interface StatisticsService {

	/**
	 * @param condition
	 * @return
	 */
	StatisticsResult statisticsNewUser(StatisticsCondition condition);

	/**
	 * @param condition
	 * @return
	 */
	StatisticsResult statisticsActiveUser(StatisticsCondition condition);

	/**
	 * @param condition
	 * @return
	 */
	StatisticsResult statisticsPayUser(StatisticsCondition condition);

}
