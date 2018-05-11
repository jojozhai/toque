/*
 * 项目名称：toque-core
 * 类名称: PraiseSpec.java
 * 创建时间: 2018年1月12日 下午6:08:52
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
import com.proginn.toque.domain.Praise;
import com.proginn.toque.dto.PraiseCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class PraiseSpec extends BasicSpecification<Praise, PraiseCondition> {

	/**
	 * @param condition
	 */
	public PraiseSpec(PraiseCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Praise> queryWraper) {
		addBetweenCondition(queryWraper, "createdTime");
	}

}
