/*
 * 项目名称：toque-admin
 * 类名称: LessonStatController.java
 * 创建时间: 2018年1月4日 上午11:36:18
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proginn.toque.dto.LessonStatCondition;
import com.proginn.toque.dto.LessonStatInfo;
import com.proginn.toque.service.LessonStatService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/lessonStat")
public class LessonStatController {
	
	@Autowired
	private LessonStatService lessonStatService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public LessonStatInfo create(@RequestBody LessonStatInfo info) {
		return lessonStatService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public LessonStatInfo update(@RequestBody LessonStatInfo info) {
		return lessonStatService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		lessonStatService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<LessonStatInfo> query(LessonStatCondition condition, Pageable pageable) {
		pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Direction.DESC, "lesson.createdTime");
		return lessonStatService.query(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public LessonStatInfo get(@PathVariable Long id) {
		return lessonStatService.get(id);
	}

}
