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
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.proginn.security.rbac.repository.BasicRepository;
import com.proginn.toque.domain.User;
import com.proginn.toque.domain.UserType;

/**
 * @author zhailiang@jd.com
 *
 */
public interface UserRepository extends BasicRepository<User> {
	
	@Query("select count(u.id) from User u where u.registTime >= ?1")
	int countByRegistTime(Date startDate);

	@Query("select count(u.id) from User u where u.lastLoginTime >= ?1")
	int countByLastLoginTime(Date startDate);
	/**
	 * @param startOfDay
	 * @return
	 */
	@Query("select count(distinct u.id) from User u where u.lastLoginTime >= ?1")
	int countByLastLoginTime2(Date startOfDay);
	/**
	 * @param chef
	 * @return
	 */
	List<User> findByUserType(UserType type);


	/**
	 * @param b
	 * @return
	 */
	
}
