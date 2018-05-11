/*
 * 项目名称：toque-core
 * 类名称: Message.java
 * 创建时间: 2018年1月4日 上午9:27:39
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.MessageInfo;

/**
 * 消息
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Message extends DomainImpl {

	/**
	 * 模板
	 */
	@ManyToOne
	private Template template;
	/**
	 * 用户
	 */
	private String user;
	/**
	 * 通知内容
	 */
	@Lob
	private String letterContent;
	/**
	 * 通知内容
	 */
	@Lob
	private String smsContent;
	/**
	 * 通知内容
	 */
	@Lob
	private String emailContent;
	/**
	 * 
	 */
	@Lob
	private String emailTitle;
	
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
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}
	/**
	 * @param template the template to set
	 */
	public void setTemplate(Template template) {
		this.template = template;
	}
	/**
	 * @return
	 */
	public MessageInfo toMessageInfo() {
		MessageInfo messageInfo = new MessageInfo();
		BeanUtils.copyProperties(this, messageInfo);
		if(getTemplate() != null) {
			messageInfo.setTemplateId(getTemplate().getId());
			messageInfo.setTemplateType(getTemplate().getType());
		}
		if(StringUtils.isBlank(messageInfo.getLetterContent())) {
			if(StringUtils.isNotBlank(getSmsContent())) {
				messageInfo.setLetterContent(getSmsContent());
			}else {
				messageInfo.setLetterContent(getEmailContent());
			}
		}
		return messageInfo;
	}
	
}
