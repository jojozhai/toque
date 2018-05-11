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

import org.springframework.data.domain.Sort;

import com.proginn.security.rbac.repository.BasicRepository;
import com.proginn.toque.domain.Statistics;

/**
 * @author zhailiang@jd.com
 *
 */
public interface StatisticsRepository extends BasicRepository<Statistics> {

	/**
	 * @param startTime
	 * @param endTime
	 * @param sort 
	 * @return
	 */
	List<Statistics> findByDateBetween(Date startTime, Date endTime, Sort sort);

}
