/*
 * 项目名称：toque-core
 * 类名称: ModuleSpec.java
 * 创建时间: 2018年1月10日 下午1:58:46
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
import com.proginn.toque.domain.Module;
import com.proginn.toque.dto.ModuleCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class ModuleSpec extends BasicSpecification<Module, ModuleCondition> {

	/**
	 * @param condition
	 */
	public ModuleSpec(ModuleCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Module> queryWraper) {
		addLikeCondition(queryWraper, "title");
		addLikeCondition(queryWraper, "titleE");
	}

}
