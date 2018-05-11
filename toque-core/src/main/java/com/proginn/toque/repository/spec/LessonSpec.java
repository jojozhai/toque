/*
 * 项目名称：toque-core
 * 类名称: LessonSpec.java
 * 创建时间: 2018年1月10日 下午3:58:06
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
import com.proginn.toque.domain.Lesson;
import com.proginn.toque.dto.LessonCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class LessonSpec extends BasicSpecification<Lesson, LessonCondition> {

	/**
	 * @param condition
	 */
	public LessonSpec(LessonCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Lesson> queryWraper) {
		addLikeCondition(queryWraper, "title");
		addLikeCondition(queryWraper, "titleE");
	}

}
