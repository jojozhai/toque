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
import com.proginn.toque.domain.LessonPlay;

/**
 * @author zhailiang@jd.com
 *
 */
public interface LessonPlayRepository extends BasicRepository<LessonPlay> {

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(lp.id) from LessonPlay lp where lp.createdTime >= ?1")
	Long countPlayPv(Date startOfDay);
	
	@Query("select count(lp.id) from LessonPlay lp where lp.lesson = ?1 and lp.createdTime >= ?2")
	Long countPlayPv(Lesson lesson, Date startOfDay);

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(distinct lp.user) from LessonPlay lp where lp.createdTime >= ?1")
	Long countPlayUv(Date startOfDay);
	
	@Query("select count(distinct lp.user) from LessonPlay lp where lp.lesson = ?1 and lp.createdTime >= ?2")
	Long countPlayUv(Lesson lesson, Date startOfDay);

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select sum(length) from LessonPlay lp where lp.createdTime >= ?1")
	Long sumPlayTime(Date startOfDay);
	
	@Query("select sum(length) from LessonPlay lp where lp.lesson = ?1 and lp.createdTime >= ?2")
	Long sumPlayTime(Lesson lesson, Date startOfDay);

	/**
	 * @param lesson
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(lp.id) from LessonPlay lp where lp.lesson = ?1 and lp.createdTime >= ?2 and finish = ?3")
	Long countFinished(Lesson lesson, Date startOfDay, Boolean finish);
	
}
