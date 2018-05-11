/*
 * 项目名称：toque-core
 * 类名称: UserInfo.java
 * 创建时间: 2018年1月4日 上午10:58:44
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

import com.proginn.toque.domain.TemplateType;

/**
 * @author zhailiang@jd.com
 *
 */
public class MessageInfo {
	
	private Long id;
	/**
	 * 发送时间
	 */
	private Date createdTime;
	/**
	 * 模板id
	 */
	private Long templateId;
	/**
	 * 模板id
	 */
	private TemplateType templateType;
	/**
	 * 通知对象
	 */
	private String user;
	/**
	 * 通知内容
	 */
	private String letterContent;
	/**
	 * 通知内容
	 */
	private String smsContent;
	/**
	 * 通知内容
	 */
	private String emailContent;
	/**
	 * 
	 */
	private String emailTitle;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
	 * @return the templateId
	 */
	public Long getTemplateId() {
		return templateId;
	}
	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
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
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the letterContent
	 */
	public String getLetterContent() {
		return letterContent;
	}
	/**
	 * @param letterContent the letterContent to set
	 */
	public void setLetterContent(String letterContent) {
		this.letterContent = letterContent;
	}
	/**
	 * @return the smsContent
	 */
	public String getSmsContent() {
		return smsContent;
	}
	/**
	 * @param smsContent the smsContent to set
	 */
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	/**
	 * @return the emailContent
	 */
	public String getEmailContent() {
		return emailContent;
	}
	/**
	 * @param emailContent the emailContent to set
	 */
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	/**
	 * @return the emailTitle
	 */
	public String getEmailTitle() {
		return emailTitle;
	}
	/**
	 * @param emailTitle the emailTitle to set
	 */
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}
	
}
