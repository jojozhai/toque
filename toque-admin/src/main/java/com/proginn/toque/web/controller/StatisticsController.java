/*
 * 项目名称：toque-admin
 * 类名称: UserController.java
 * 创建时间: 2018年1月4日 上午11:36:18
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proginn.security.rbac.domain.Admin;
import com.proginn.toque.dto.FirstPageInfo;
import com.proginn.toque.dto.StatisticsCondition;
import com.proginn.toque.dto.StatisticsResult;
import com.proginn.toque.service.StatisticsService;
import com.proginn.toque.service.UserService;

/**
 * @author zhailiang@jd.com
 *
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	/**
	 * 统计首页信息
	 * @param id
	 * @return
	 */
	@GetMapping("/index")
	public FirstPageInfo statisticsIndex(@AuthenticationPrincipal Admin	admin) {
		FirstPageInfo stat = userService.statisticsIndex();
		stat.setLoginTime(admin.getLastLoginTime());
		return stat;
	}
	
	/**
	 * 新用户统计
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@PostMapping("/user/new")
	public StatisticsResult query(@RequestBody StatisticsCondition condition) {
		return statisticsService.statisticsNewUser(condition);
	}
	
	/**
	 * 活跃用户统计
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@PostMapping("/user/active")
	public StatisticsResult active(@RequestBody StatisticsCondition condition) {
		return statisticsService.statisticsActiveUser(condition);
	}
	
	/**
	 * 活跃用户统计
	 * @param condition
	 * @param pageable
	 * @return
	 */
	@PostMapping("/user/pay")
	public StatisticsResult pay(@RequestBody StatisticsCondition condition) {
		return statisticsService.statisticsPayUser(condition);
	}

}
