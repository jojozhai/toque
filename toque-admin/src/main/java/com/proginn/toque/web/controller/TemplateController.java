/*
 * 项目名称：toque-admin
 * 类名称: TemplateController.java
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

import com.proginn.toque.dto.TemplateCondition;
import com.proginn.toque.dto.TemplateInfo;
import com.proginn.toque.service.TemplateService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public TemplateInfo create(@RequestBody TemplateInfo info) {
		return templateService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public TemplateInfo update(@RequestBody TemplateInfo info) {
		return templateService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		templateService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<TemplateInfo> query(TemplateCondition condition, Pageable pageable) {
		return templateService.query(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public TemplateInfo get(@PathVariable Long id) {
		return templateService.get(id);
	}
	
	/**
	 * 启用
	 * @param id
	 */
	@PutMapping("/{id}/enable")
	public void enable(@PathVariable Long id) {
		templateService.enable(id);
	}
	
	/**
	 * 禁用
	 * @param id
	 */
	@PutMapping("/{id}/disable")
	public void disable(@PathVariable Long id) {
		templateService.disable(id);
	}

}
