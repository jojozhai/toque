/*
 * 项目名称：toque-core
 * 类名称: PraiseService.java
 * 创建时间: 2018年1月4日 上午10:58:19
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.PraiseCondition;
import com.proginn.toque.dto.PraiseInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface PraiseService {
	
	/**
	 * 创建赞
	 * @param info
	 * @return
	 */
	PraiseInfo create(PraiseInfo info);
	/**
	 * 修改赞信息
	 * @param info
	 * @return
	 */
	PraiseInfo update(PraiseInfo info);
	/**
	 * 删除赞
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询赞信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<PraiseInfo> query(PraiseCondition condition, Pageable pageable, LanguageType languageType);
	/**
	 * 获取赞信息
	 * @param id
	 * @return
	 */
	PraiseInfo get(Long id, LanguageType languageType);

}
