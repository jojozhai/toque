/*
 * 项目名称：toque-core
 * 类名称: TemplateRepository.java
 * 创建时间: 2018年1月4日 上午11:21:37
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.repository;

import java.util.List;

import com.proginn.security.rbac.repository.BasicRepository;
import com.proginn.toque.domain.Template;
import com.proginn.toque.domain.TemplateType;

/**
 * @author zhailiang@jd.com
 *
 */
public interface TemplateRepository extends BasicRepository<Template> {

	/**
	 * @param b
	 * @param c
	 * @return
	 */
	List<Template> findByImmediatelyAndProcessed(boolean immediately, boolean processed);

	/**
	 * @param type
	 * @return
	 */
	Template findByType(TemplateType type);

}
