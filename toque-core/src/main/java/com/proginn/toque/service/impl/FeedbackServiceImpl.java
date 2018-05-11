/*
 * 项目名称：toque-core
 * 类名称: FeedbackServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:02:46
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Feedback;
import com.proginn.toque.domain.Message;
import com.proginn.toque.dto.FeedbackCondition;
import com.proginn.toque.dto.FeedbackInfo;
import com.proginn.toque.repository.FeedbackRepository;
import com.proginn.toque.repository.MessageRepository;
import com.proginn.toque.repository.spec.FeedbackSpec;
import com.proginn.toque.service.FeedbackService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.FeedbackService#create(com.proginn.toque.dto.FeedbackInfo)
	 */
	@Override
	public FeedbackInfo create(FeedbackInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.FeedbackService#update(com.proginn.toque.dto.FeedbackInfo)
	 */
	@Override
	public FeedbackInfo update(FeedbackInfo info) {
		Feedback feedback = feedbackRepository.findOne(info.getId());
		feedback.setReply(info.getReply());
		feedback.setReplyTime(new Date());
		
		Message message = new Message();
		message.setLetterContent(info.getReply());
		message.setTemplate(null);
		message.setUser(feedback.getUsername());
		messageRepository.save(message);
		
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.FeedbackService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.FeedbackService#query(com.proginn.toque.dto.FeedbackCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<FeedbackInfo> query(FeedbackCondition condition, Pageable pageable) {
		Page<Feedback> feedbacks = feedbackRepository.findAll(new FeedbackSpec(condition), pageable);
		return QueryResultConverter.convert(feedbacks, pageable, (feedback) -> feedback.toFeedbackInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.FeedbackService#get(java.lang.Long)
	 */
	@Override
	public FeedbackInfo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	

}
