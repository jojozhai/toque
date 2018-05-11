/*
 * 项目名称：toque-core
 * 类名称: CategoryService.java
 * 创建时间: 2018年1月4日 上午10:58:19
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.CategoryCondition;
import com.proginn.toque.dto.CategoryInfo;
import com.proginn.toque.dto.Option;

/**
 * @author zhailiang@jd.com
 *
 */
public interface CategoryService {
	
	/**
	 * 创建门类
	 * @param info
	 * @return
	 */
	CategoryInfo create(CategoryInfo info);
	/**
	 * 修改门类信息
	 * @param info
	 * @return
	 */
	CategoryInfo update(CategoryInfo info);
	/**
	 * 删除门类
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询门类信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<CategoryInfo> query(CategoryCondition condition, Pageable pageable);
	/**
	 * 获取门类信息
	 * @param id
	 * @return
	 */
	CategoryInfo get(Long id);
	/**
	 * @return
	 */
	List<Option> findAll(LanguageType languageType);

}
