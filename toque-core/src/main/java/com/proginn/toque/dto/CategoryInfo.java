/*
 * 项目名称：toque-core
 * 类名称: CategoryInfo.java
 * 创建时间: 2018年1月10日 上午11:34:37
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
public class CategoryInfo {
	
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 标题 
	 */
	private String title;
	/**
	 * 标题英
	 */
	private String titleE;
	/**
	 * 模块数量
	 */
	private int moduleCount;
	

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
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titleE
	 */
	public String getTitleE() {
		return titleE;
	}

	/**
	 * @param titleE the titleE to set
	 */
	public void setTitleE(String titleE) {
		this.titleE = titleE;
	}

	/**
	 * @return the moduleCount
	 */
	public int getModuleCount() {
		return moduleCount;
	}

	/**
	 * @param moduleCount the moduleCount to set
	 */
	public void setModuleCount(int moduleCount) {
		this.moduleCount = moduleCount;
	}
	
}
