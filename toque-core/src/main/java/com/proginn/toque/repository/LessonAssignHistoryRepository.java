/*
 * 项目名称：toque-core
 * 类名称: UserRepository.java
 * 创建时间: 2018年1月4日 上午10:57:32
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
import com.proginn.toque.domain.LessonAssignHistory;

/**
 * @author zhailiang@jd.com
 *
 */
public interface LessonAssignHistoryRepository extends BasicRepository<LessonAssignHistory> {

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(lph.id) from LessonAssignHistory lph where lph.createdTime >= ?1")
	Long countPv(Date startOfDay);
	
	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(distinct lph.chef) from LessonAssignHistory lph where lph.createdTime >= ?1")
	Long countUv(Date startOfDay);
	
}
