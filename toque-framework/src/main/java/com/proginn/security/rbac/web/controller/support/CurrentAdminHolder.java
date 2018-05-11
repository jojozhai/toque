/*
 * 项目名称：cpc-saas-admin
 * 类名称: CurrentAdminHolder.java
 * 创建时间: 2018年1月12日 上午10:50:27
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.security.rbac.web.controller.support;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.proginn.security.rbac.domain.Admin;

/**
 * @author zhailiang@jd.com
 *
 */
public class CurrentAdminHolder {
	
	public static Long getCurrentAdminId() {
		Long result = null;
		Admin admin = getCurrentAdmin();
		if(admin != null) {
			result = admin.getId();
		}
		return result;
	}
	
	public static Admin getCurrentAdmin() {
		Admin result = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if(context != null) {
			Authentication authentication = context.getAuthentication();
			if(authentication != null) {
				Object principal = authentication.getPrincipal();
				if(principal != null &&
						principal instanceof Admin) {
					result = (Admin)principal;
				}
			}
		}
		return result;
	}

}
