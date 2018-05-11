/*
 * 项目名称：toque-core
 * 类名称: RestaurantStatInfo.java
 * 创建时间: 2018年1月19日 上午10:25:27
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

/**
 * @author zhailiang@jd.com
 *
 */
public class RestaurantStatInfo {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 餐厅名称 
	 */
	private String name;
	
	/**
	 * 
	 */
	private Integer count;

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
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	

}
