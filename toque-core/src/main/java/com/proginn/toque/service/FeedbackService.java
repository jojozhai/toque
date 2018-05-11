/*
 * 项目名称：toque-core
 * 类名称: FeedbackService.java
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

import com.proginn.toque.dto.FeedbackCondition;
import com.proginn.toque.dto.FeedbackInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface FeedbackService {
	
	/**
	 * 创建用户
	 * @param info
	 * @return
	 */
	FeedbackInfo create(FeedbackInfo info);
	/**
	 * 修改用户信息
	 * @param info
	 * @return
	 */
	FeedbackInfo update(FeedbackInfo info);
	/**
	 * 删除用户
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询用户信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<FeedbackInfo> query(FeedbackCondition condition, Pageable pageable);
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	FeedbackInfo get(Long id);

}
