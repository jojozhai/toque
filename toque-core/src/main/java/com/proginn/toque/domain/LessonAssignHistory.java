/*
 * 项目名称：toque-core
 * 类名称: LessonAssignHistory.java
 * 创建时间: 2018年1月25日 下午2:42:08
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class LessonAssignHistory extends DomainImpl {

	@ManyToOne
	private User chef;

	/**
	 * @return the chef
	 */
	public User getChef() {
		return chef;
	}

	/**
	 * @param chef the chef to set
	 */
	public void setChef(User chef) {
		this.chef = chef;
	}
	
}
