/*
 * 项目名称：toque-core
 * 类名称: TemplateSpec.java
 * 创建时间: 2018年1月4日 上午11:26:50
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
import com.proginn.toque.domain.Template;
import com.proginn.toque.dto.TemplateCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class TemplateSpec extends BasicSpecification<Template, TemplateCondition> {

	/**
	 * @param condition
	 */
	public TemplateSpec(TemplateCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.repository.support.BasicSpecification#addCondition(com.proginn.toque.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Template> queryWraper) {
		
	}

}
