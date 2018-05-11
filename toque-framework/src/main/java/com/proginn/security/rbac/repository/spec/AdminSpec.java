/**
 * 
 */
package com.proginn.security.rbac.repository.spec;

import com.proginn.security.rbac.domain.Admin;
import com.proginn.security.rbac.dto.AdminCondition;
import com.proginn.security.rbac.repository.support.BasicSpecification;
import com.proginn.security.rbac.repository.support.QueryWraper;

/**
 * @author zhailiang
 *
 */
public class AdminSpec extends BasicSpecification<Admin, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Admin> queryWraper) {
		addLikeCondition(queryWraper, "username");
	}

}
