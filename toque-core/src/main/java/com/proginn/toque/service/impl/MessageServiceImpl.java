/*
 * 项目名称：toque-core
 * 类名称: MessageServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:02:46
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Message;
import com.proginn.toque.dto.MessageCondition;
import com.proginn.toque.dto.MessageInfo;
import com.proginn.toque.repository.MessageRepository;
import com.proginn.toque.repository.spec.MessageSpec;
import com.proginn.toque.service.MessageService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	/* (non-Javadoc)
	 * @see com.proginn.toque.service.MessageService#create(com.proginn.toque.dto.MessageInfo)
	 */
	@Override
	public MessageInfo create(MessageInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.MessageService#update(com.proginn.toque.dto.MessageInfo)
	 */
	@Override
	public MessageInfo update(MessageInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.MessageService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.MessageService#query(com.proginn.toque.dto.MessageCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<MessageInfo> query(MessageCondition condition, Pageable pageable) {
		Page<Message> messages = messageRepository.findAll(new MessageSpec(condition), pageable);
		return QueryResultConverter.convert(messages, pageable, (message) -> message.toMessageInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.MessageService#get(java.lang.Long)
	 */
	@Override
	public MessageInfo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
