/*
 * 项目名称：toque-core
 * 类名称: VideoPlay.java
 * 创建时间: 2018年1月18日 上午10:02:46
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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 课程播放信息
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class LessonPlay extends DomainImpl {
	
	/**
	 * 课程
	 */
	@ManyToOne
	private Lesson lesson;
	/**
	 * 用户
	 */
	@ManyToOne
	private User user;
	/**
	 * 播放开始时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	/**
	 * 播放结束时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	/**
	 * 播放时长
	 */
	private Long length;
	/**
	 * 是否播放完毕
	 */
	private Boolean finish;
	
	/**
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}
	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the length
	 */
	public Long getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Long length) {
		this.length = length;
	}
	/**
	 * @return the finish
	 */
	public Boolean getFinish() {
		return finish;
	}
	/**
	 * @param finish the finish to set
	 */
	public void setFinish(Boolean finish) {
		this.finish = finish;
	}

}
