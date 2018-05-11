/*
 * 项目名称：toque-core
 * 类名称: MessageService.java
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

import com.proginn.toque.dto.MessageCondition;
import com.proginn.toque.dto.MessageInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface MessageService {
	
	/**
	 * 创建消息
	 * @param info
	 * @return
	 */
	MessageInfo create(MessageInfo info);
	/**
	 * 修改消息信息
	 * @param info
	 * @return
	 */
	MessageInfo update(MessageInfo info);
	/**
	 * 删除消息
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询消息信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<MessageInfo> query(MessageCondition condition, Pageable pageable);
	/**
	 * 获取消息信息
	 * @param id
	 * @return
	 */
	MessageInfo get(Long id);

}
