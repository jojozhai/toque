/*
 * 项目名称：toque-core
 * 类名称: Step.java
 * 创建时间: 2018年1月10日 上午11:20:56
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author zhailiang@jd.com
 *
 */
@Embeddable
public class Step {

	/**
	 * 文字描述
	 */
	@Column(length = 2000)
	private String content;
	/**
	 * 图片
	 */
	private String image;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}
