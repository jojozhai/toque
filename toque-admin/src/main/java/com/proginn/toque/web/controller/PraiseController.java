/*
 * 项目名称：toque-admin
 * 类名称: PraiseController.java
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

import com.proginn.security.rbac.web.controller.support.CurrentAdminHolder;
import com.proginn.toque.dto.PraiseCondition;
import com.proginn.toque.dto.PraiseInfo;
import com.proginn.toque.service.PraiseService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/praise")
public class PraiseController {
	
	@Autowired
	private PraiseService praiseService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public PraiseInfo create(@RequestBody PraiseInfo info) {
		return praiseService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public PraiseInfo update(@RequestBody PraiseInfo info) {
		return praiseService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		praiseService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<PraiseInfo> query(PraiseCondition condition, Pageable pageable) {
		return praiseService.query(condition, pageable, CurrentAdminHolder.getCurrentAdmin().getLanguageType());
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public PraiseInfo get(@PathVariable Long id) {
		return praiseService.get(id, CurrentAdminHolder.getCurrentAdmin().getLanguageType());
	}

}
