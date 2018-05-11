/*
 * 项目名称：toque-admin
 * 类名称: RestaurantController.java
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

import com.proginn.toque.dto.RestaurantCondition;
import com.proginn.toque.dto.RestaurantInfo;
import com.proginn.toque.dto.RestaurantStatInfo;
import com.proginn.toque.service.RestaurantService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public RestaurantInfo create(@RequestBody RestaurantInfo info) {
		return restaurantService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public RestaurantInfo update(@RequestBody RestaurantInfo info) {
		return restaurantService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		restaurantService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<RestaurantInfo> query(RestaurantCondition condition, Pageable pageable) {
		return restaurantService.query(condition, pageable);
	}
	
	/**
	 * 统计
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping("/stat")
	public Page<RestaurantStatInfo> stat(RestaurantCondition condition, Pageable pageable) {
		return restaurantService.stat(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public RestaurantInfo get(@PathVariable Long id) {
		return restaurantService.get(id);
	}
	
	/**
	 * 启用
	 * @param id
	 */
	@PutMapping("/{id}/enable")
	public void enable(@PathVariable Long id) {
		restaurantService.enable(id);
	}
	
	/**
	 * 禁用
	 * @param id
	 */
	@PutMapping("/{id}/disable")
	public void disable(@PathVariable Long id) {
		restaurantService.disable(id);
	}

}
