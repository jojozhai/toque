/*
 * 项目名称：toque-core
 * 类名称: UserCondition.java
 * 创建时间: 2018年1月4日 上午11:00:00
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

import com.proginn.toque.domain.TemplateType;

/**
 * @author zhailiang@jd.com
 *
 */
public class MessageCondition {
	
	/**
	 * 发送时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;
	/**
	 * 发送时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdTimeTo;
	/**
	 * 模板类型
	 */
	private TemplateType templateType;
	
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
	/**
	 * @return the templateType
	 */
	public TemplateType getTemplateType() {
		return templateType;
	}
	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}
	
}
