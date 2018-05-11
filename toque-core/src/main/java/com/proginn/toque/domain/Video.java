/*
 * 项目名称：toque-core
 * 类名称: Video.java
 * 创建时间: 2018年1月11日 上午11:30:31
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Video extends DomainImpl {
	
	/**
	 * 所属视频组
	 */
	@ManyToOne
	private VideoGroup group;
	/**
	 * 视频地址
	 */
	private String url;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 下一组视频
	 */
	@ManyToOne
	private VideoGroup next;
	/**
	 * 下一组视频的顺序号
	 */
	private Integer nextSort;

	/**
	 * @return the group
	 */
	public VideoGroup getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(VideoGroup group) {
		this.group = group;
	}

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
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return the next
	 */
	public VideoGroup getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(VideoGroup next) {
		this.next = next;
	}

	/**
	 * @return the nextSort
	 */
	public Integer getNextSort() {
		return nextSort;
	}

	/**
	 * @param nextSort the nextSort to set
	 */
	public void setNextSort(Integer nextSort) {
		this.nextSort = nextSort;
	}
	
}
