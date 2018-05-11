/*
 * 项目名称：toque-core
 * 类名称: UserStaticticsSpec.java
 * 创建时间: 2018年1月5日 下午3:00:08
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.repository.spec;

import java.util.Date;

import org.joda.time.DateTime;

import com.proginn.security.rbac.repository.support.BasicSpecification;
import com.proginn.security.rbac.repository.support.QueryWraper;
import com.proginn.toque.domain.User;
import com.proginn.toque.dto.UserStaticticsCondition;
import com.proginn.toque.dto.UserStaticticsEnum;

/**
 * @author zhailiang@jd.com
 *
 */
public class UserStatisticsForIndexSpec extends BasicSpecification<User, UserStaticticsCondition> {

	/**
	 * @param condition
	 */
	public UserStatisticsForIndexSpec(UserStaticticsCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<User> queryWraper) {
		addEqualsCondition(queryWraper, "userType");
		
		Date today = new DateTime().withTimeAtStartOfDay().toDate();
		if(UserStaticticsEnum.NEW.equals(getCondition().getStatType())) {
			addGreaterThanConditionToColumn(queryWraper, "createdTime", today);
		}else if(UserStaticticsEnum.ACTIVE.equals(getCondition().getStatType())) {
			addGreaterThanConditionToColumn(queryWraper, "lastLoginTime", today);
		}
		
	}

}
