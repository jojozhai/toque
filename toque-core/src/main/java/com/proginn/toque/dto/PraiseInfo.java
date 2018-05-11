/*
 * 项目名称：toque-core
 * 类名称: CategoryInfo.java
 * 创建时间: 2018年1月10日 上午11:34:37
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

/**
 * @author zhailiang@jd.com
 *
 */
public class PraiseInfo {
	
	private Long id;
	private Date createdTime;
	/**
	 * 课程
	 */
	private Long lessonId;
	private String lessonName;
	/**
	 * 用户
	 */
	private Long userId;
	private String username;
	/**
	 * 赞
	 */
	private Boolean praise;
	/**
	 * 评价内容
	 */
	private String content;
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
	 * @return the lessonId
	 */
	public Long getLessonId() {
		return lessonId;
	}
	/**
	 * @param lessonId the lessonId to set
	 */
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}
	/**
	 * @return the lessonName
	 */
	public String getLessonName() {
		return lessonName;
	}
	/**
	 * @param lessonName the lessonName to set
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	 * @return the praise
	 */
	public Boolean getPraise() {
		return praise;
	}
	/**
	 * @param praise the praise to set
	 */
	public void setPraise(Boolean praise) {
		this.praise = praise;
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
	
}
