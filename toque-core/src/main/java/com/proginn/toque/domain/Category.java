/*
 * 项目名称：toque-core
 * 类名称: Category.java
 * 创建时间: 2018年1月10日 上午9:39:25
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.CategoryInfo;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Category extends DomainImpl {
	
	/**
	 * 标题 
	 */
	private String title;
	/**
	 * 标题英
	 */
	private String titleE;
	/**
	 * 模块
	 */
	@OneToMany(mappedBy = "category")
	private Set<Module> modules = new HashSet<>();
	
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
	 * @return the modules
	 */
	public Set<Module> getModules() {
		return modules;
	}
	/**
	 * @param modules the modules to set
	 */
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	/**
	 * @return
	 */
	public CategoryInfo toCategoryInfo() {
		CategoryInfo info = new CategoryInfo();
		BeanUtils.copyProperties(this, info);
		if(CollectionUtils.isNotEmpty(getModules())) {
			info.setModuleCount(getModules().size());
		}
		return info;
	}
	
}
