/*
 * 项目名称：toque-core
 * 类名称: LessonStatService.java
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

import com.proginn.toque.dto.LessonStatCondition;
import com.proginn.toque.dto.LessonStatInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface LessonStatService {
	
	/**
	 * 创建课程统计
	 * @param info
	 * @return
	 */
	LessonStatInfo create(LessonStatInfo info);
	/**
	 * 修改课程统计信息
	 * @param info
	 * @return
	 */
	LessonStatInfo update(LessonStatInfo info);
	/**
	 * 删除课程统计
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询课程统计信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<LessonStatInfo> query(LessonStatCondition condition, Pageable pageable);
	/**
	 * 获取课程统计信息
	 * @param id
	 * @return
	 */
	LessonStatInfo get(Long id);

}
