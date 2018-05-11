/*
 * 项目名称：toque-core
 * 类名称: ModuleServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:24:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.i18n.LanguageType;
import com.proginn.security.rbac.repository.support.AbstractDomain2InfoConverter;
import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Module;
import com.proginn.toque.dto.ModuleCondition;
import com.proginn.toque.dto.ModuleInfo;
import com.proginn.toque.dto.Option;
import com.proginn.toque.repository.CategoryRepository;
import com.proginn.toque.repository.ModuleRepository;
import com.proginn.toque.repository.spec.ModuleSpec;
import com.proginn.toque.service.ModuleService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#create(com.proginn.toque.dto.ModuleInfo)
	 */
	@Override
	public ModuleInfo create(ModuleInfo info) {
		Module module = new Module();
		BeanUtils.copyProperties(info, module);
		module.setCategory(categoryRepository.getOne(info.getCategoryId()));
		info.setId(moduleRepository.save(module).getId());
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#update(com.proginn.toque.dto.ModuleInfo)
	 */
	@Override
	public ModuleInfo update(ModuleInfo info) {
		Module module = moduleRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, module);
		module.setCategory(categoryRepository.getOne(info.getCategoryId()));
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		moduleRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#query(com.proginn.toque.dto.ModuleCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<ModuleInfo> query(ModuleCondition condition, Pageable pageable) {
		Page<Module> modules = moduleRepository.findAll(new ModuleSpec(condition), pageable);
		return QueryResultConverter.convert(modules, pageable, (Module) -> Module.toModuleInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#get(java.lang.Long)
	 */
	@Override
	public ModuleInfo get(Long id) {
		return moduleRepository.findOne(id).toModuleInfo();
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#findAll()
	 */
	@Override
	public List<Option> findAll(LanguageType languageType) {
		return QueryResultConverter.convert(moduleRepository.findAll(), new AbstractDomain2InfoConverter<Module, Option>() {
			@Override
			protected void doConvert(Module domain, Option info) throws Exception {
				info.setName(LanguageType.CHINESE.equals(languageType) ? domain.getTitle() : domain.getTitleE());
				info.setValue(domain.getId().toString());
			}
		});
	}

}
