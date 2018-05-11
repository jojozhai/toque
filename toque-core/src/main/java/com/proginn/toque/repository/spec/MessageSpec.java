/*
 * 项目名称：toque-core
 * 类名称: MessageSpec.java
 * 创建时间: 2018年1月5日 下午4:27:28
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
import com.proginn.toque.domain.Message;
import com.proginn.toque.dto.MessageCondition;

/**
 * @author zhailiang@jd.com
 *
 */
public class MessageSpec extends BasicSpecification<Message, MessageCondition> {

	/**
	 * @param condition
	 */
	public MessageSpec(MessageCondition condition) {
		super(condition);
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.repository.support.BasicSpecification#addCondition(com.proginn.security.rbac.repository.support.QueryWraper)
	 */
	@Override
	protected void addCondition(QueryWraper<Message> queryWraper) {
		addEqualsCondition(queryWraper, "templateType", "template.type");
		addBetweenCondition(queryWraper, "createdTime");
	}

}
