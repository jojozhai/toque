/*
 * 项目名称：toque-core
 * 类名称: CategoryCondition.java
 * 创建时间: 2018年1月10日 上午11:34:48
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zhailiang@jd.com
 *
 */
public class PraiseCondition {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdTimeTo;

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the createdTimeTo
	 */
	public Date getCreatedTimeTo() {
		return createdTimeTo;
	}

	/**
	 * @param createdTimeTo the createdTimeTo to set
	 */
	public void setCreatedTimeTo(Date createdTimeTo) {
		this.createdTimeTo = createdTimeTo;
	}
	
}
