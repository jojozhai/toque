/*
 * 项目名称：toque-core
 * 类名称: User.java
 * 创建时间: 2018年1月3日 下午4:26:30
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.UserInfo;

/**
 * 用户
 * 
 * @author zhailiang@jd.com
 *
 */
@Entity
public class User extends DomainImpl {
	
	/**
	 * 身份
	 */
	@Enumerated(EnumType.STRING)
	private UserType userType;
	/**
	 * 语种
	 */
	@Enumerated(EnumType.STRING)
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
	 * 国家
	 */
	private String country;
	/**
	 * 姓名
	 */
	private String realname;
	/**
	 * 餐厅
	 */
	@ManyToOne
	private Restaurant restaurant;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 最后登录时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime;
	/**
	 * 注册时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date registTime;
	/**
	 * 有效标示
	 */
	private Boolean enable;
	/**
	 * 姓
	 */
	private String surname;
	/**
	 * 名
	 */
	private String name;
	/**
	 * 指派
	 */
	@OneToMany(mappedBy = "trainee")
	private List<LessonAssign> assigns = new ArrayList<>();
	/**
	 * @param i 
	 * @return
	 */
	public UserInfo toUserInfo(int i) {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(this, userInfo);
		
		String surname = StringUtils.isBlank(getSurname()) ? "" : getSurname();
		String name = StringUtils.isBlank(getName()) ? "" : getName();
		if(LanguageType.CHINESE.equals(getLanguageType())) {
			userInfo.setRealname(surname + name);
		}else {
			userInfo.setRealname(name + " " +surname);
		}
		
		if(getRestaurant() != null) {
			userInfo.setRestaurantName(getRestaurant().getName());
		}
		
		if(UserType.CHEF.equals(getUserType())) {
			userInfo.setAssignCount("-");
		}else {
			userInfo.setAssignCount(new Integer(i).toString());
		}
		
		return userInfo;
	}
	
	/**
	 * @return the assigns
	 */
	public List<LessonAssign> getAssigns() {
		return assigns;
	}

	/**
	 * @param assigns the assigns to set
	 */
	public void setAssigns(List<LessonAssign> assigns) {
		this.assigns = assigns;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
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
	 * @return
	 */
	public String getPhoneOrEmail() {
		return StringUtils.isNotBlank(getPhone())?getPhone():getEmail();
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
