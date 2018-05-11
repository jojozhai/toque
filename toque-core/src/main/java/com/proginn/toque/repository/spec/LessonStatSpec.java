/*
 * 项目名称：toque-core
 * 类名称: LessonStatSpec.java
 * 创建时间: 2018年1月18日 上午11:01:36
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.repository.spec;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;

import com.proginn.security.rbac.repository.support.BasicSpecification;
import com.proginn.security.rbac.repository.support.QueryWraper;
import com.proginn.toque.domain.LessonStat;
import com.proginn.toque.dto.LessonStatCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class LessonStatSpec extends BasicSpecification<LessonStat, LessonStatCondition> {

	/**
	 * @param condition
	 */
	public LessonStatSpec(LessonStatCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<LessonStat> queryWraper) {
		addLikeCondition(queryWraper, "title", "lesson.title");
		addLikeCondition(queryWraper, "titleE", "lesson.titleE");
		addEqualsConditionToColumn(queryWraper, "date", new DateTime().withTimeAtStartOfDay().plusDays(-1).toDate());
	}
	
	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addFetch(javax.persistence.criteria.Root)
	 */
	@Override
	protected void addFetch(Root<LessonStat> root) {
		root.fetch("lesson", JoinType.LEFT);
	}

}
