/*
 * 项目名称：toque-core
 * 类名称: LessonAssign.java
 * 创建时间: 2018年1月18日 上午10:08:24
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
public class LessonAssign extends DomainImpl {
	
	/**
	 * 课程
	 */
	@ManyToOne
	private Lesson lesson;
	/**
	 * 主厨
	 */
	@ManyToOne
	private User chef;
	/**
	 * 学员
	 */
	@ManyToOne
	private User trainee;
	
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
	 * @return the chef
	 */
	public User getChef() {
		return chef;
	}
	/**
	 * @param chef the chef to set
	 */
	public void setChef(User chef) {
		this.chef = chef;
	}
	/**
	 * @return the trainee
	 */
	public User getTrainee() {
		return trainee;
	}
	/**
	 * @param trainee the trainee to set
	 */
	public void setTrainee(User trainee) {
		this.trainee = trainee;
	}
	
}
