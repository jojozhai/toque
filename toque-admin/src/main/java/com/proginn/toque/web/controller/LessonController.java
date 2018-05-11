/*
 * 项目名称：toque-admin
 * 类名称: LessonController.java
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
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proginn.toque.dto.LessonCondition;
import com.proginn.toque.dto.LessonInfo;
import com.proginn.toque.service.LessonService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/lesson")
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public LessonInfo create(@RequestBody LessonInfo info) {
		return lessonService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public LessonInfo update(@RequestBody LessonInfo info) {
		return lessonService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		lessonService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<LessonInfo> query(LessonCondition condition, Pageable pageable) {
		return lessonService.query(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public LessonInfo get(@PathVariable Long id) {
		return lessonService.get(id);
	}
	/**
	 * 启用
	 * @param id
	 */
	@PutMapping("/{id}/enable")
	public void enable(@PathVariable Long id) {
		lessonService.enable(id);
	}
	
	/**
	 * 禁用
	 * @param id
	 */
	@PutMapping("/{id}/disable")
	public void disable(@PathVariable Long id) {
		lessonService.disable(id);
	}

}
