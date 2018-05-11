/*
 * 项目名称：toque-admin
 * 类名称: VideoSetController.java
 * 创建时间: 2018年1月4日 上午11:36:18
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.web.controller;

import java.util.List;

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
import com.proginn.toque.dto.Option;
import com.proginn.toque.dto.VideoSetCondition;
import com.proginn.toque.dto.VideoSetInfo;
import com.proginn.toque.service.VideoSetService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/videoSet")
public class VideoSetController {
	
	@Autowired
	private VideoSetService videoSetService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public VideoSetInfo create(@RequestBody VideoSetInfo info) {
		return videoSetService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public VideoSetInfo update(@RequestBody VideoSetInfo info) {
		return videoSetService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		videoSetService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<VideoSetInfo> query(VideoSetCondition condition, Pageable pageable) {
		return videoSetService.query(condition, pageable, CurrentAdminHolder.getCurrentAdmin().getLanguageType());
	}
	
	/**
	 * 全部
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping("/all")
	public List<Option> findAll() {
		return videoSetService.findAll();
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public VideoSetInfo get(@PathVariable Long id) {
		return videoSetService.get(id, CurrentAdminHolder.getCurrentAdmin().getLanguageType());
	}

}
