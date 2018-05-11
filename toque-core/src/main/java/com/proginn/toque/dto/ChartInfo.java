/*
 * 项目名称：toque-core
 * 类名称: ChartInfo.java
 * 创建时间: 2018年1月5日 下午6:47:06
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.List;

/**
 * @author zhailiang@jd.com
 *
 */
public class ChartInfo {
	
	public ChartInfo(String serie, List<String> labels, List<Integer> data) {
		this.labels = labels.toArray(new String[labels.size()]);
		this.series = new String[] {serie};
		this.data = new Integer[][] {data.toArray(new Integer[data.size()])};
	}
	
	private String[] labels;
	
	private String[] series;
	
	private Integer[][] data;

	/**
	 * @return the labels
	 */
	public String[] getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	/**
	 * @return the series
	 */
	public String[] getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(String[] series) {
		this.series = series;
	}

	public Integer[][] getData() {
		return data;
	}

	public void setData(Integer[][] data) {
		this.data = data;
	}

}
