/*
 * 项目名称：toque-core
 * 类名称: MessageSender.java
 * 创建时间: 2018年1月15日 上午10:51:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.schedule;

import com.proginn.toque.domain.Template;
import com.proginn.toque.domain.TemplateType;

/**
 * @author zhailiang@jd.com
 *
 */
public interface MessageSender {
	
	/**
	 * @param template
	 */
	void send(Template template);
	
	/**
	 * @param template
	 * @param userId
	 */
	void send(TemplateType template, Long userId);
	
	/**
	 * @param template
	 * @param userId
	 * @param callback
	 */
	void send(TemplateType template, Long userId, MessageSendCallback callback);

}
