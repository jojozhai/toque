/*
 * 项目名称：toque-core
 * 类名称: UserSpec.java
 * 创建时间: 2018年1月4日 上午11:07:20
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
import com.proginn.toque.domain.User;
import com.proginn.toque.dto.UserCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class UserSpec extends BasicSpecification<User, UserCondition> {

	/**
	 * @param condition
	 */
	public UserSpec(UserCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.repository.support.ImoocSpecification#addCondition(com.proginn.toque.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<User> queryWraper) {
		addEqualsCondition(queryWraper, "userType");
		addLikeCondition(queryWraper, "phone");
		addLikeCondition(queryWraper, "email");
		addLikeCondition(queryWraper, "restaurantName", "restaurant.name");
	}

}
