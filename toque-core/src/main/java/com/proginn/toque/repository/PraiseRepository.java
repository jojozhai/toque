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
import com.proginn.toque.domain.Praise;

/**
 * @author zhailiang@jd.com
 *
 */
public interface PraiseRepository extends BasicRepository<Praise> {

	/**
	 * @param lesson
	 * @param startOfDay
	 * @param b
	 * @return
	 */
	@Query("select count(p.id) from Praise p where p.lesson = ?1 and p.createdTime >= ?2 and p.praise = ?3")
	Long countByLesson(Lesson lesson, Date startOfDay, boolean praise);
	
}
