/*
 * 项目名称：toque-core
 * 类名称: MessageSendCallback.java
 * 创建时间: 2018年1月15日 下午4:35:22
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.schedule;

import com.proginn.toque.domain.Message;

/**
 * @author zhailiang@jd.com
 *
 */
public interface MessageSendCallback {
	
	void doOnMessage(Message message);

}
