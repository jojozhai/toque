/*
 * 项目名称：toque-core
 * 类名称: UserStatistics.java
 * 创建时间: 2018年1月5日 下午2:51:33
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
public class FirstPageInfo {
	
	private Date loginTime;
	
	private long allUser;
	
	private long allPayUser;
	
	private long newUser;
	
	private long newUserChef;
	
	private long newUserTrainee;
	
	private long activeUser;
	
	private long activeUserChef;
	
	private long activeUserTrainee;
	
	private long payUser;
	
	private long payUserVip2;
	
	private long payUserVip3;
	
	private long payUserVip4;
	
	private long playToday;
	
	private String avgTimeWeek;
	
	private long avgAssignWeek;
	
	private long kinchenPv;
	
	private long avgPlayTotal;
	
	private long countPlayTotal;
	
	
	/**
	 * @return the allPayUser
	 */
	public long getAllPayUser() {
		return allPayUser;
	}

	/**
	 * @param allPayUser the allPayUser to set
	 */
	public void setAllPayUser(long allPayUser) {
		this.allPayUser = allPayUser;
	}

	/**
	 * @return the playToday
	 */
	public long getPlayToday() {
		return playToday;
	}

	/**
	 * @param playToday the playToday to set
	 */
	public void setPlayToday(long playToday) {
		this.playToday = playToday;
	}

	/**
	 * @return the avgTimeWeek
	 */
	public String getAvgTimeWeek() {
		return avgTimeWeek;
	}

	/**
	 * @param avgTimeWeek the avgTimeWeek to set
	 */
	public void setAvgTimeWeek(String avgTimeWeek) {
		this.avgTimeWeek = avgTimeWeek;
	}

	/**
	 * @return the avgAssignWeek
	 */
	public long getAvgAssignWeek() {
		return avgAssignWeek;
	}

	/**
	 * @param avgAssignWeek the avgAssignWeek to set
	 */
	public void setAvgAssignWeek(long avgAssignWeek) {
		this.avgAssignWeek = avgAssignWeek;
	}

	/**
	 * @return the kinchenPv
	 */
	public long getKinchenPv() {
		return kinchenPv;
	}

	/**
	 * @param kinchenPv the kinchenPv to set
	 */
	public void setKinchenPv(long kinchenPv) {
		this.kinchenPv = kinchenPv;
	}

	/**
	 * @return the avgPlayTotal
	 */
	public long getAvgPlayTotal() {
		return avgPlayTotal;
	}

	/**
	 * @param avgPlayTotal the avgPlayTotal to set
	 */
	public void setAvgPlayTotal(long avgPlayTotal) {
		this.avgPlayTotal = avgPlayTotal;
	}

	/**
	 * @return the countPlayTotal
	 */
	public long getCountPlayTotal() {
		return countPlayTotal;
	}

	/**
	 * @param countPlayTotal the countPlayTotal to set
	 */
	public void setCountPlayTotal(long countPlayTotal) {
		this.countPlayTotal = countPlayTotal;
	}

	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the allUser
	 */
	public long getAllUser() {
		return allUser;
	}

	/**
	 * @param allUser the allUser to set
	 */
	public void setAllUser(long allUser) {
		this.allUser = allUser;
	}

	/**
	 * @return the newUser
	 */
	public long getNewUser() {
		return newUser;
	}

	/**
	 * @param newUser the newUser to set
	 */
	public void setNewUser(long newUser) {
		this.newUser = newUser;
	}

	/**
	 * @return the newUserChef
	 */
	public long getNewUserChef() {
		return newUserChef;
	}

	/**
	 * @param newUserChef the newUserChef to set
	 */
	public void setNewUserChef(long newUserChef) {
		this.newUserChef = newUserChef;
	}

	/**
	 * @return the newUserTrainee
	 */
	public long getNewUserTrainee() {
		return newUserTrainee;
	}

	/**
	 * @param newUserTrainee the newUserTrainee to set
	 */
	public void setNewUserTrainee(long newUserTrainee) {
		this.newUserTrainee = newUserTrainee;
	}

	/**
	 * @return the activeUser
	 */
	public long getActiveUser() {
		return activeUser;
	}

	/**
	 * @param activeUser the activeUser to set
	 */
	public void setActiveUser(long activeUser) {
		this.activeUser = activeUser;
	}

	/**
	 * @return the activeUserChef
	 */
	public long getActiveUserChef() {
		return activeUserChef;
	}

	/**
	 * @param activeUserChef the activeUserChef to set
	 */
	public void setActiveUserChef(long activeUserChef) {
		this.activeUserChef = activeUserChef;
	}

	/**
	 * @return the activeUserTrainee
	 */
	public long getActiveUserTrainee() {
		return activeUserTrainee;
	}

	/**
	 * @param activeUserTrainee the activeUserTrainee to set
	 */
	public void setActiveUserTrainee(long activeUserTrainee) {
		this.activeUserTrainee = activeUserTrainee;
	}

	/**
	 * @return the payUser
	 */
	public long getPayUser() {
		return payUser;
	}

	/**
	 * @param payUser the payUser to set
	 */
	public void setPayUser(long payUser) {
		this.payUser = payUser;
	}

	/**
	 * @return the payUserVip2
	 */
	public long getPayUserVip2() {
		return payUserVip2;
	}

	/**
	 * @param payUserVip2 the payUserVip2 to set
	 */
	public void setPayUserVip2(long payUserVip2) {
		this.payUserVip2 = payUserVip2;
	}

	/**
	 * @return the payUserVip3
	 */
	public long getPayUserVip3() {
		return payUserVip3;
	}

	/**
	 * @param payUserVip3 the payUserVip3 to set
	 */
	public void setPayUserVip3(long payUserVip3) {
		this.payUserVip3 = payUserVip3;
	}

	/**
	 * @return the payUserVip4
	 */
	public long getPayUserVip4() {
		return payUserVip4;
	}

	/**
	 * @param payUserVip4 the payUserVip4 to set
	 */
	public void setPayUserVip4(long payUserVip4) {
		this.payUserVip4 = payUserVip4;
	}
	
}
