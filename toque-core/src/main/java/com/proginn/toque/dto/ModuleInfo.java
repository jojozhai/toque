/*
 * 项目名称：toque-core
 * 类名称: ModuleInfo.java
 * 创建时间: 2018年1月10日 下午1:54:21
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

import com.proginn.toque.domain.ModuleType;

/**
 * @author zhailiang@jd.com
 *
 */
public class ModuleInfo {
	
	private Long id;
	/**
	 * 门类id
	 */
	private Long categoryId;
	/**
	 * 标题 
	 */
	private String title;
	/**
	 * 标题英
	 */
	private String titleE;
	/**
	 * 标签
	 */
	private String tag;
	/**
	 * 标签英
	 */
	private String tagE;
	/**
	 * 封面
	 */
	private String cover;
	/**
	 * 封面英
	 */
	private String coverE;
	/**
	 * 简介
	 */
	private String desc;
	/**
	 * 简介英
	 */
	private String descE;
	/**
	 * 模块属性
	 */
	private ModuleType type;
	/**
	 * 课程总数
	 */
	private int lessonCount;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the titleE
	 */
	public String getTitleE() {
		return titleE;
	}
	/**
	 * @param titleE the titleE to set
	 */
	public void setTitleE(String titleE) {
		this.titleE = titleE;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the tagE
	 */
	public String getTagE() {
		return tagE;
	}
	/**
	 * @param tagE the tagE to set
	 */
	public void setTagE(String tagE) {
		this.tagE = tagE;
	}
	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the coverE
	 */
	public String getCoverE() {
		return coverE;
	}
	/**
	 * @param coverE the coverE to set
	 */
	public void setCoverE(String coverE) {
		this.coverE = coverE;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the descE
	 */
	public String getDescE() {
		return descE;
	}
	/**
	 * @param descE the descE to set
	 */
	public void setDescE(String descE) {
		this.descE = descE;
	}
	/**
	 * @return the type
	 */
	public ModuleType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ModuleType type) {
		this.type = type;
	}
	/**
	 * @return the lessonCount
	 */
	public int getLessonCount() {
		return lessonCount;
	}
	/**
	 * @param lessonCount the lessonCount to set
	 */
	public void setLessonCount(int lessonCount) {
		this.lessonCount = lessonCount;
	}
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
