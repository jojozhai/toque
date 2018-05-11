/*
 * 项目名称：toque-core
 * 类名称: TemplateInfo.java
 * 创建时间: 2018年1月4日 上午11:23:23
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

import com.proginn.toque.domain.TemplateScope;
import com.proginn.toque.domain.TemplateType;

/**
 * @author zhailiang@jd.com
 *
 */
public class TemplateInfo {
	
	private Long id;
	/**
	 * 模板编号
	 */
	private String number;
	/**
	 * 类型
	 */
	private TemplateType type;
	/**
	 * 通知范围
	 */
	private TemplateScope scope;
	/**
	 * 发送方式. 为true时立即发送，false定时发送
	 */
	private Boolean immediately;
	/**
	 * 计划发送时间
	 */
	private Date planSendTime;
	/**
	 * 模板内容中文
	 */
	private String letterContent;
	/**
	 * 模板内容英文
	 */
	private String letterContentE;
	/**
	 * 模板内容中文
	 */
	private String smsContent;
	/**
	 * 模板内容英文
	 */
	private String smsContentE;
	/**
	 * 模板内容中文
	 */
	private String emailContent;
	/**
	 * 模板内容英文
	 */
	private String emailContentE;
	/**
	 * 模板内容中文
	 */
	private String emailTitle;
	/**
	 * 模板内容英文
	 */
	private String emailTitleE;
	/**
	 * 是否可用
	 */
	private Boolean enable;
	/**
	 * 链接
	 */
	private String link;
	/**
	 * 是否同步发送短信和邮件
	 */
	private Boolean sendSmsAndEmail;
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the type
	 */
	public TemplateType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TemplateType type) {
		this.type = type;
	}
	/**
	 * @return the scope
	 */
	public TemplateScope getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(TemplateScope scope) {
		this.scope = scope;
	}
	/**
	 * @return the immediately
	 */
	public Boolean getImmediately() {
		return immediately;
	}
	/**
	 * @param immediately the immediately to set
	 */
	public void setImmediately(Boolean immediately) {
		this.immediately = immediately;
	}
	/**
	 * @return the planSendTime
	 */
	public Date getPlanSendTime() {
		return planSendTime;
	}
	/**
	 * @param planSendTime the planSendTime to set
	 */
	public void setPlanSendTime(Date planSendTime) {
		this.planSendTime = planSendTime;
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
	 * @return the letterContentE
	 */
	public String getLetterContentE() {
		return letterContentE;
	}
	/**
	 * @param letterContentE the letterContentE to set
	 */
	public void setLetterContentE(String letterContentE) {
		this.letterContentE = letterContentE;
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
	 * @return the smsContentE
	 */
	public String getSmsContentE() {
		return smsContentE;
	}
	/**
	 * @param smsContentE the smsContentE to set
	 */
	public void setSmsContentE(String smsContentE) {
		this.smsContentE = smsContentE;
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
	 * @return the emailContentE
	 */
	public String getEmailContentE() {
		return emailContentE;
	}
	/**
	 * @param emailContentE the emailContentE to set
	 */
	public void setEmailContentE(String emailContentE) {
		this.emailContentE = emailContentE;
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
	/**
	 * @return the emailTitleE
	 */
	public String getEmailTitleE() {
		return emailTitleE;
	}
	/**
	 * @param emailTitleE the emailTitleE to set
	 */
	public void setEmailTitleE(String emailTitleE) {
		this.emailTitleE = emailTitleE;
	}
	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the sendSmsAndEmail
	 */
	public Boolean getSendSmsAndEmail() {
		return sendSmsAndEmail;
	}
	/**
	 * @param sendSmsAndEmail the sendSmsAndEmail to set
	 */
	public void setSendSmsAndEmail(Boolean sendSmsAndEmail) {
		this.sendSmsAndEmail = sendSmsAndEmail;
	}
	
}
