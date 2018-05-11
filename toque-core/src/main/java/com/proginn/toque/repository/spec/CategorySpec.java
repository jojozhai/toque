/*
 * 项目名称：toque-core
 * 类名称: CategorySpec.java
 * 创建时间: 2018年1月10日 上午11:36:26
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.repository.spec;

import com.proginn.security.rbac.repository.support.BasicSpecification;
import com.proginn.security.rbac.repository.support.QueryWraper;
import com.proginn.toque.domain.Category;
import com.proginn.toque.dto.CategoryCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class CategorySpec extends BasicSpecification<Category, CategoryCondition> {

	/**
	 * @param condition
	 */
	public CategorySpec(CategoryCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Category> queryWraper) {
		
	}

}
