/*
 * 项目名称：toque-core
 * 类名称: Feedback.java
 * 创建时间: 2018年1月4日 上午9:41:13
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.FeedbackInfo;

/**
 * 反馈
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Feedback extends DomainImpl {
	
	/**
	 * 反馈用户
	 */
	private String username;
	/**
	 * 反馈内容
	 */
	@Lob
	private String content;
	/**
	 * 回复内容
	 */
	@Lob
	private String reply;
	/**
	 * 回复时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date replyTime;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}
	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * @return the replyTime
	 */
	public Date getReplyTime() {
		return replyTime;
	}
	/**
	 * @param replyTime the replyTime to set
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	/**
	 * @return
	 */
	public FeedbackInfo toFeedbackInfo() {
		FeedbackInfo info = new FeedbackInfo();
		BeanUtils.copyProperties(this, info);
		if(StringUtils.isNotBlank(getReply())) {
			info.setStatus("replyed");
		}else {
			info.setStatus("waiting");
		}
		return info;
	}
	
}
