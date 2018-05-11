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

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.domain.UserType;

/**
 * @author zhailiang@jd.com
 *
 */
public class UserInfo {
	
	private Long id;
	/**
	 * 身份
	 */
	private UserType userType;
	/**
	 * 语种
	 */
	private LanguageType languageType;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 姓名
	 */
	private String realname;
	/**
	 * 餐厅名称
	 */
	private String restaurantName;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 注册时间
	 */
	private Date registTime;
	/**
	 * 有效标示
	 */
	private Boolean enable;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 指派课程数量
	 */
	private String assignCount;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
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
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	/**
	 * @return the languageType
	 */
	public LanguageType getLanguageType() {
		return languageType;
	}
	/**
	 * @param languageType the languageType to set
	 */
	public void setLanguageType(LanguageType languageType) {
		this.languageType = languageType;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * @return the restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}
	/**
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the registTime
	 */
	public Date getRegistTime() {
		return registTime;
	}
	/**
	 * @param registTime the registTime to set
	 */
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
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
	 * @return the assignCount
	 */
	public String getAssignCount() {
		return assignCount;
	}
	/**
	 * @param assignCount the assignCount to set
	 */
	public void setAssignCount(String assignCount) {
		this.assignCount = assignCount;
	}

}
