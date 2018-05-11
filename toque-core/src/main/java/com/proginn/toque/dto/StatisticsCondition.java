/*
 * 项目名称：toque-core
 * 类名称: StatisticsCondition.java
 * 创建时间: 2018年1月5日 下午6:18:53
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

/**
 * @author zhailiang@jd.com
 *
 */
public class StatisticsCondition {
	
	/**
	 * 统计单位(日，周，月，只对活跃用户统计起效)
	 */
	private String statUnit;
	
	private Date startTime;
	
	private Date endTime;

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the statUnit
	 */
	public String getStatUnit() {
		return statUnit;
	}

	/**
	 * @param statUnit the statUnit to set
	 */
	public void setStatUnit(String statUnit) {
		this.statUnit = statUnit;
	}
	
}
