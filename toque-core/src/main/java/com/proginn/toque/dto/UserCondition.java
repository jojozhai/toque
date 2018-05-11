/*
 * 项目名称：toque-core
 * 类名称: UserCondition.java
 * 创建时间: 2018年1月4日 上午11:00:00
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import com.proginn.toque.domain.UserType;

/**
 * @author zhailiang@jd.com
 *
 */
public class UserCondition {
	
	/**
	 * 身份
	 */
	private UserType userType;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 餐厅名称
	 */
	private String restaurantName;
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

}
