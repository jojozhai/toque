/*
 * 项目名称：toque-core
 * 类名称: ModuleService.java
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
import com.proginn.toque.dto.ModuleCondition;
import com.proginn.toque.dto.ModuleInfo;
import com.proginn.toque.dto.Option;

/**
 * @author zhailiang@jd.com
 *
 */
public interface ModuleService {
	
	/**
	 * 创建模块
	 * @param info
	 * @return
	 */
	ModuleInfo create(ModuleInfo info);
	/**
	 * 修改模块信息
	 * @param info
	 * @return
	 */
	ModuleInfo update(ModuleInfo info);
	/**
	 * 删除模块
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询模块信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<ModuleInfo> query(ModuleCondition condition, Pageable pageable);
	/**
	 * 获取模块信息
	 * @param id
	 * @return
	 */
	ModuleInfo get(Long id);
	/**
	 * @return
	 */
	List<Option> findAll(LanguageType languageType);
}
