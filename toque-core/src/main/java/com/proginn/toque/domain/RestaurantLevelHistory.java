/*
 * 项目名称：toque-core
 * 类名称: RestaurantLevelHistory.java
 * 创建时间: 2018年1月3日 下午5:16:18
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 餐厅等级变化历史
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class RestaurantLevelHistory extends DomainImpl {
	
	/**
	 * 用户
	 */
	@ManyToOne
	private User user;
	/**
	 * 餐厅
	 */
	@ManyToOne
	private Restaurant restaurant;
	/**
	 * 原等级
	 */
	@Enumerated(EnumType.STRING)
	private RestaurantLevel oldLevel;
	/**
	 * 原到期时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date oldEndTime;
	/**
	 * 新等级
	 */
	@Enumerated(EnumType.STRING)
	private RestaurantLevel newLevel;
	/**
	 * 新到期时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date newEndTime;
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
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}
	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	/**
	 * @return the oldLevel
	 */
	public RestaurantLevel getOldLevel() {
		return oldLevel;
	}
	/**
	 * @param oldLevel the oldLevel to set
	 */
	public void setOldLevel(RestaurantLevel oldLevel) {
		this.oldLevel = oldLevel;
	}
	/**
	 * @return the oldEndTime
	 */
	public Date getOldEndTime() {
		return oldEndTime;
	}
	/**
	 * @param oldEndTime the oldEndTime to set
	 */
	public void setOldEndTime(Date oldEndTime) {
		this.oldEndTime = oldEndTime;
	}
	/**
	 * @return the newLevel
	 */
	public RestaurantLevel getNewLevel() {
		return newLevel;
	}
	/**
	 * @param newLevel the newLevel to set
	 */
	public void setNewLevel(RestaurantLevel newLevel) {
		this.newLevel = newLevel;
	}
	/**
	 * @return the newEndTime
	 */
	public Date getNewEndTime() {
		return newEndTime;
	}
	/**
	 * @param newEndTime the newEndTime to set
	 */
	public void setNewEndTime(Date newEndTime) {
		this.newEndTime = newEndTime;
	}

}
