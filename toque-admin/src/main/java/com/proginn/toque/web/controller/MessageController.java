/*
 * 项目名称：toque-admin
 * 类名称: MessageController.java
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

import com.proginn.toque.dto.MessageCondition;
import com.proginn.toque.dto.MessageInfo;
import com.proginn.toque.service.MessageService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 创建
	 * @param info
	 * @return
	 */
	@PostMapping
	public MessageInfo create(@RequestBody MessageInfo info) {
		return messageService.create(info);
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@PutMapping("/{id}")
	public MessageInfo update(@RequestBody MessageInfo info) {
		return messageService.update(info);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		messageService.delete(id);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@PostMapping("/query")
	public Page<MessageInfo> query2(@RequestBody MessageCondition condition, Pageable pageable) {
		return messageService.query(condition, pageable);
	}
	
	/**
	 * 分页查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<MessageInfo> query(MessageCondition condition, Pageable pageable) {
		return messageService.query(condition, pageable);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public MessageInfo get(@PathVariable Long id) {
		return messageService.get(id);
	}

}
