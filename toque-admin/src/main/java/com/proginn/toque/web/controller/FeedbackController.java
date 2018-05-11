/*
 * 项目名称：toque-admin
 * 类名称: FeedbackController.java
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

import com.proginn.toque.dto.FeedbackCondition;
import com.proginn.toque.dto.FeedbackInfo;
import com.proginn.toque.service.FeedbackService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public FeedbackInfo create(@RequestBody FeedbackInfo info) {
		return feedbackService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public FeedbackInfo update(@RequestBody FeedbackInfo info) {
		return feedbackService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		feedbackService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<FeedbackInfo> query(FeedbackCondition condition, Pageable pageable) {
		return feedbackService.query(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public FeedbackInfo get(@PathVariable Long id) {
		return feedbackService.get(id);
	}

}
