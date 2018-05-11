/*
 * 项目名称：toque-core
 * 类名称: UserStaticticsCondition.java
 * 创建时间: 2018年1月5日 下午3:00:42
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
public class UserStaticticsCondition {
	
	private UserType userType;
	
	private UserStaticticsEnum statType;
	
	public UserStaticticsCondition(UserStaticticsEnum statType) {
		this.statType = statType;
	}
	
	public UserStaticticsCondition(UserStaticticsEnum statType, UserType userType) {
		this.statType = statType;
		this.userType = userType;
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
	 * @return the statType
	 */
	public UserStaticticsEnum getStatType() {
		return statType;
	}

	/**
	 * @param statType the statType to set
	 */
	public void setStatType(UserStaticticsEnum statType) {
		this.statType = statType;
	}

}
