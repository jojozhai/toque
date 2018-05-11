/*
 * 项目名称：toque-core
 * 类名称: Restaurant.java
 * 创建时间: 2018年1月3日 下午4:42:38
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.RestaurantInfo;

/**
 * 餐厅
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Restaurant extends DomainImpl {

	/**
	 * 邀请码
	 */
	private String inviteCode;
	/**
	 * 餐厅名称
	 */
	private String name;
	/**
	 * 餐厅类型
	 */
	private String type;
	/**
	 * 菜式类型
	 */
	private String dishType;
	/**
	 * 有效标识
	 */
	private Boolean enable;
	/**
	 * 特权等级
	 */
	@Enumerated(EnumType.STRING)
	private RestaurantLevel level;
	/**
	 * 团队人数上限
	 */
	private Integer teamLimit;
	/**
	 * 特权到期时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date prerogativeEndTime;
	/**
	 * 是否付费
	 */
	private Boolean pay;
	/**
	 * 付费等级
	 */
	@Enumerated(EnumType.STRING)
	private RestaurantLevel payLevel;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 等级变化历史
	 */
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
	private List<RestaurantLevelHistory> histories;
	/**
	 * 所有用户
	 */
	@OneToMany(mappedBy = "restaurant")
	private List<User> users;
	
	
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the inviteCode
	 */
	public String getInviteCode() {
		return inviteCode;
	}
	/**
	 * @param inviteCode the inviteCode to set
	 */
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the dishType
	 */
	public String getDishType() {
		return dishType;
	}
	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(String dishType) {
		this.dishType = dishType;
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
	 * @return the level
	 */
	public RestaurantLevel getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(RestaurantLevel level) {
		this.level = level;
	}
	/**
	 * @return the teamLimit
	 */
	public Integer getTeamLimit() {
		return teamLimit;
	}
	/**
	 * @param teamLimit the teamLimit to set
	 */
	public void setTeamLimit(Integer teamLimit) {
		this.teamLimit = teamLimit;
	}
	/**
	 * @return the prerogativeEndTime
	 */
	public Date getPrerogativeEndTime() {
		return prerogativeEndTime;
	}
	/**
	 * @param prerogativeEndTime the prerogativeEndTime to set
	 */
	public void setPrerogativeEndTime(Date prerogativeEndTime) {
		this.prerogativeEndTime = prerogativeEndTime;
	}
	/**
	 * @return the pay
	 */
	public Boolean getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(Boolean pay) {
		this.pay = pay;
	}
	/**
	 * @return the payLevel
	 */
	public RestaurantLevel getPayLevel() {
		return payLevel;
	}
	/**
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(RestaurantLevel payLevel) {
		this.payLevel = payLevel;
	}
	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return the histories
	 */
	public List<RestaurantLevelHistory> getHistories() {
		return histories;
	}
	/**
	 * @param histories the histories to set
	 */
	public void setHistories(List<RestaurantLevelHistory> histories) {
		this.histories = histories;
	}
	/**
	 * @return
	 */
	public RestaurantInfo toRestaurantInfo() {
		RestaurantInfo info = new RestaurantInfo();
		BeanUtils.copyProperties(this, info);
		return info;
	}
	
	
}
