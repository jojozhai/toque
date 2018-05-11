/*
 * 项目名称：toque-core
 * 类名称: VideoSetSpec.java
 * 创建时间: 2018年1月11日 下午2:07:21
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

import com.proginn.security.rbac.repository.support.BasicSpecification;
import com.proginn.security.rbac.repository.support.QueryWraper;
import com.proginn.toque.domain.VideoSet;
import com.proginn.toque.dto.VideoSetCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class VideoSetSpec extends BasicSpecification<VideoSet, VideoSetCondition> {

	/**
	 * @param condition
	 */
	public VideoSetSpec(VideoSetCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<VideoSet> queryWraper) {
		addLikeCondition(queryWraper, "name");
	}
	
	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addFetch(javax.persistence.criteria.Root)
	 */
	@Override
	protected void addFetch(Root<VideoSet> root) {
		root.fetch("lesson", JoinType.LEFT);
	}

}
