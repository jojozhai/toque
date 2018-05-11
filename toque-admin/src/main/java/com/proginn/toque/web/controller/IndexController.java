/*
 * 项目名称：toque-admin
 * 类名称: IndexController.java
 * 创建时间: 2018年2月5日 下午3:11:12
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhailiang@jd.com
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
    public String index() {
        return "forward:/manage.html";
    }
	
}
