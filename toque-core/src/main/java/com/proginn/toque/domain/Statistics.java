/*
 * 项目名称：toque-core
 * 类名称: Statistics.java
 * 创建时间: 2018年1月5日 下午6:35:27
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Statistics extends DomainImpl {

	/**
	 * 统计日期
	 */
	@Temporal(TemporalType.DATE)
	private Date date;
	/**
	 * 注册用户数
	 */
	private int registCount;
	/**
	 * 日活跃用户数
	 */
	private int activeCount;
	/**
	 * 周活跃用户数
	 */
	private int activeCountForWeek;
	/**
	 * 月活跃用户数
	 */
	private int activeCountForMonth;
	/**
	 * 支付用户数
	 */
	private int payCount;
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the registCount
	 */
	public int getRegistCount() {
		return registCount;
	}
	/**
	 * @param registCount the registCount to set
	 */
	public void setRegistCount(int registCount) {
		this.registCount = registCount;
	}
	/**
	 * @return the activeCount
	 */
	public int getActiveCount() {
		return activeCount;
	}
	/**
	 * @param activeCount the activeCount to set
	 */
	public void setActiveCount(int activeCount) {
		this.activeCount = activeCount;
	}
	/**
	 * @return the payCount
	 */
	public int getPayCount() {
		return payCount;
	}
	/**
	 * @param payCount the payCount to set
	 */
	public void setPayCount(int payCount) {
		this.payCount = payCount;
	}
	public int getActiveCountForWeek() {
		return activeCountForWeek;
	}
	public void setActiveCountForWeek(int activeCountForWeek) {
		this.activeCountForWeek = activeCountForWeek;
	}
	public int getActiveCountForMonth() {
		return activeCountForMonth;
	}
	public void setActiveCountForMonth(int activeCountForMonth) {
		this.activeCountForMonth = activeCountForMonth;
	}
	
}
