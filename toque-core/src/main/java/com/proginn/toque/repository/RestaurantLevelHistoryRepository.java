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

import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import com.proginn.security.rbac.repository.BasicRepository;
import com.proginn.toque.domain.RestaurantLevel;
import com.proginn.toque.domain.RestaurantLevelHistory;

/**
 * @author zhailiang@jd.com
 *
 */
public interface RestaurantLevelHistoryRepository extends BasicRepository<RestaurantLevelHistory> {
	
	@Query("select count(distinct h.user) from RestaurantLevelHistory h where h.newLevel = ?1 and h.createdTime > ?2")
	int countByLevel(RestaurantLevel level, Date date);
	
	@Query("select count(distinct h.user) from RestaurantLevelHistory h where h.createdTime > ?1")
	int countByDate(Date date);

}
