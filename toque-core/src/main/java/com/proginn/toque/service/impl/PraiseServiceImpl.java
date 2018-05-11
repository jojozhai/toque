/*
 * 项目名称：toque-core
 * 类名称: PraiseServiceImpl.java
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

import com.proginn.security.i18n.LanguageType;
import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Praise;
import com.proginn.toque.dto.PraiseCondition;
import com.proginn.toque.dto.PraiseInfo;
import com.proginn.toque.repository.PraiseRepository;
import com.proginn.toque.repository.spec.PraiseSpec;
import com.proginn.toque.service.PraiseService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class PraiseServiceImpl implements PraiseService {
	
	@Autowired
	private PraiseRepository praiseRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.PraiseService#create(com.proginn.toque.dto.PraiseInfo)
	 */
	@Override
	public PraiseInfo create(PraiseInfo info) {
		Praise praise = new Praise();
		BeanUtils.copyProperties(info, praise);
		info.setId(praiseRepository.save(praise).getId());
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.PraiseService#update(com.proginn.toque.dto.PraiseInfo)
	 */
	@Override
	public PraiseInfo update(PraiseInfo info) {
		Praise praise = praiseRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, praise);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.PraiseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		praiseRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.PraiseService#query(com.proginn.toque.dto.PraiseCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<PraiseInfo> query(PraiseCondition condition, Pageable pageable, LanguageType languageType) {
		Page<Praise> praises = praiseRepository.findAll(new PraiseSpec(condition), pageable);
		return QueryResultConverter.convert(praises, pageable, (Praise) -> Praise.toPraiseInfo(languageType));
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.PraiseService#get(java.lang.Long)
	 */
	@Override
	public PraiseInfo get(Long id, LanguageType languageType) {
		return praiseRepository.findOne(id).toPraiseInfo(languageType);
	}

}
