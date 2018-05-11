/*
 * 项目名称：toque-core
 * 类名称: RestaurantService.java
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

import com.proginn.toque.dto.RestaurantCondition;
import com.proginn.toque.dto.RestaurantInfo;
import com.proginn.toque.dto.RestaurantStatInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface RestaurantService {
	
	/**
	 * 创建餐厅
	 * @param info
	 * @return
	 */
	RestaurantInfo create(RestaurantInfo info);
	/**
	 * 修改餐厅信息
	 * @param info
	 * @return
	 */
	RestaurantInfo update(RestaurantInfo info);
	/**
	 * 删除餐厅
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询餐厅信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<RestaurantInfo> query(RestaurantCondition condition, Pageable pageable);
	/**
	 * 获取餐厅信息
	 * @param id
	 * @return
	 */
	RestaurantInfo get(Long id);
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
	
	Page<RestaurantStatInfo> stat(RestaurantCondition condition, Pageable pageable);

}
