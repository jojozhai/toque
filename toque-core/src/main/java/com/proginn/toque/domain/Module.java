/*
 * 项目名称：toque-core
 * 类名称: Module.java
 * 创建时间: 2018年1月10日 上午9:39:10
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.ModuleInfo;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Module extends DomainImpl {

	/**
	 * 分类
	 */
	@ManyToOne
	private Category category;
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
	@Enumerated(EnumType.STRING)
	private ModuleType type;
	/**
	 * 课程
	 */
	@OneToMany(mappedBy = "module")
	private Set<Lesson> lessons = new HashSet<>();
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
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
	 * @return the lessons
	 */
	public Set<Lesson> getLessons() {
		return lessons;
	}
	/**
	 * @param lessons the lessons to set
	 */
	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}
	/**
	 * @return
	 */
	public ModuleInfo toModuleInfo() {
		ModuleInfo info = new ModuleInfo();
		BeanUtils.copyProperties(this, info);
		info.setCategoryId(getCategory().getId());
		if(CollectionUtils.isNotEmpty(getLessons())) {
			info.setLessonCount(getLessons().size());
		}
		return info;
	}
	
}
