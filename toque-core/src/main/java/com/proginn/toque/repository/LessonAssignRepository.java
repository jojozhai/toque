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
import com.proginn.toque.domain.Lesson;
import com.proginn.toque.domain.LessonAssign;

/**
 * @author zhailiang@jd.com
 *
 */
public interface LessonAssignRepository extends BasicRepository<LessonAssign> {

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(la.id) from LessonAssign la where la.lesson = ?1 and la.createdTime >= ?2")
	Long countByLesson(Lesson lesson, Date startOfDay);
	
}
