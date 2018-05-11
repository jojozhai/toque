/*
 * 项目名称：toque-core
 * 类名称: StatisticsResult.java
 * 创建时间: 2018年1月5日 下午6:20:34
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

/**
 * @author zhailiang@jd.com
 *
 */
public class StatisticsResult {
	
	private ChartInfo chart;
	
	private int newUserCount;
	private int activeUserCount;
	
	public StatisticsResult(ChartInfo chart){
		this.chart = chart;
	}

	public ChartInfo getChart() {
		return chart;
	}

	public void setChart(ChartInfo chart) {
		this.chart = chart;
	}

	public int getNewUserCount() {
		return newUserCount;
	}

	public void setNewUserCount(int newUserCount) {
		this.newUserCount = newUserCount;
	}

	public int getActiveUserCount() {
		return activeUserCount;
	}

	public void setActiveUserCount(int activeUserCount) {
		this.activeUserCount = activeUserCount;
	}
	
}
