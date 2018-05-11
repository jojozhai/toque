/*
 * 项目名称：toque-core
 * 类名称: CategoryServiceImpl.java
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
import com.proginn.toque.domain.Category;
import com.proginn.toque.dto.CategoryCondition;
import com.proginn.toque.dto.CategoryInfo;
import com.proginn.toque.dto.Option;
import com.proginn.toque.repository.CategoryRepository;
import com.proginn.toque.repository.spec.CategorySpec;
import com.proginn.toque.service.CategoryService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#create(com.proginn.toque.dto.CategoryInfo)
	 */
	@Override
	public CategoryInfo create(CategoryInfo info) {
		Category category = new Category();
		BeanUtils.copyProperties(info, category);
		info.setId(categoryRepository.save(category).getId());
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#update(com.proginn.toque.dto.CategoryInfo)
	 */
	@Override
	public CategoryInfo update(CategoryInfo info) {
		Category category = categoryRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, category);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#query(com.proginn.toque.dto.CategoryCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<CategoryInfo> query(CategoryCondition condition, Pageable pageable) {
		Page<Category> categorys = categoryRepository.findAll(new CategorySpec(condition), pageable);
		return QueryResultConverter.convert(categorys, pageable, (Category) -> Category.toCategoryInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#get(java.lang.Long)
	 */
	@Override
	public CategoryInfo get(Long id) {
		return categoryRepository.findOne(id).toCategoryInfo();
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.CategoryService#findAll()
	 */
	@Override
	public List<Option> findAll(LanguageType languageType) {
		return QueryResultConverter.convert(categoryRepository.findAll(), new AbstractDomain2InfoConverter<Category, Option>() {
			@Override
			protected void doConvert(Category domain, Option info) throws Exception {
				info.setName(LanguageType.CHINESE.equals(languageType) ? domain.getTitle() : domain.getTitleE());
				info.setValue(domain.getId().toString());
			}
		});
	}

}
