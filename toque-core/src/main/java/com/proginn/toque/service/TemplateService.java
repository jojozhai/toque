/*
 * 项目名称：toque-core
 * 类名称: TemplateService.java
 * 创建时间: 2018年1月4日 上午10:58:19
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proginn.toque.dto.TemplateCondition;
import com.proginn.toque.dto.TemplateInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface TemplateService {
	
	/**
	 * 创建模板
	 * @param info
	 * @return
	 */
	TemplateInfo create(TemplateInfo info);
	/**
	 * 修改模板信息
	 * @param info
	 * @return
	 */
	TemplateInfo update(TemplateInfo info);
	/**
	 * 删除模板
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询模板信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<TemplateInfo> query(TemplateCondition condition, Pageable pageable);
	/**
	 * 获取模板信息
	 * @param id
	 * @return
	 */
	TemplateInfo get(Long id);
	/**
	 * 启用
	 * @param id
	 */
	void enable(Long id);
	/**
	 * 禁用
	 * @param id
	 */
	void disable(Long id);

}
