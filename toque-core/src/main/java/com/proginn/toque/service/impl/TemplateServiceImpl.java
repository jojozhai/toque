/*
 * 项目名称：toque-core
 * 类名称: TemplateServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:24:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Template;
import com.proginn.toque.dto.TemplateCondition;
import com.proginn.toque.dto.TemplateInfo;
import com.proginn.toque.repository.TemplateRepository;
import com.proginn.toque.repository.spec.TemplateSpec;
import com.proginn.toque.schedule.MessageSender;
import com.proginn.toque.service.TemplateService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private MessageSender messageSender;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#create(com.proginn.toque.dto.TemplateInfo)
	 */
	@Override
	public TemplateInfo create(TemplateInfo info) {
		Template template = new Template();
		BeanUtils.copyProperties(info, template);
		template.setProcessed(false);
		info.setId(templateRepository.save(template).getId());
		if(template.getImmediately()) {
			messageSender.send(template);
		}
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#update(com.proginn.toque.dto.TemplateInfo)
	 */
	@Override
	public TemplateInfo update(TemplateInfo info) {
		Template template = templateRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, template);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		templateRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#query(com.proginn.toque.dto.TemplateCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<TemplateInfo> query(TemplateCondition condition, Pageable pageable) {
		Page<Template> templates = templateRepository.findAll(new TemplateSpec(condition), pageable);
		return QueryResultConverter.convert(templates, pageable, (template) -> template.toTemplateInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#get(java.lang.Long)
	 */
	@Override
	public TemplateInfo get(Long id) {
		return templateRepository.findOne(id).toTemplateInfo();
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#enable(java.lang.Long)
	 */
	@Override
	public void enable(Long id) {
		Template template = templateRepository.findOne(id);
		template.setEnable(true);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.TemplateService#disable(java.lang.Long)
	 */
	@Override
	public void disable(Long id) {
		Template template = templateRepository.findOne(id);
		template.setEnable(false);
	}

}
