/*
 * 项目名称：toque-core
 * 类名称: LessonService.java
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

import com.proginn.toque.dto.LessonCondition;
import com.proginn.toque.dto.LessonInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface LessonService {
	
	/**
	 * 创建门类
	 * @param info
	 * @return
	 */
	LessonInfo create(LessonInfo info);
	/**
	 * 修改门类信息
	 * @param info
	 * @return
	 */
	LessonInfo update(LessonInfo info);
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
	Page<LessonInfo> query(LessonCondition condition, Pageable pageable);
	/**
	 * 获取门类信息
	 * @param id
	 * @return
	 */
	LessonInfo get(Long id);
	/**
	 * @param id
	 */
	void enable(Long id);
	/**
	 * @param id
	 */
	void disable(Long id);

}
