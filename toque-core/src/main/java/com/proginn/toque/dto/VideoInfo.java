/*
 * 项目名称：toque-core
 * 类名称: VideoInfo.java
 * 创建时间: 2018年1月11日 下午1:42:30
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
public class VideoInfo {
	
	/**
	 * 视频地址
	 */
	private String url;
	/**
	 * 下一组视频
	 */
	private String nextSort;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the nextSort
	 */
	public String getNextSort() {
		return nextSort;
	}
	/**
	 * @param nextSort the nextSort to set
	 */
	public void setNextSort(String nextSort) {
		this.nextSort = nextSort;
	}

}
