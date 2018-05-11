/*
 * 项目名称：toque-core
 * 类名称: Lesson.java
 * 创建时间: 2018年1月10日 上午9:38:14
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.BeanUtils;

import com.proginn.toque.dto.LessonInfo;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Lesson extends DomainImpl {

	/**
	 * 所属模块
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Module module;
	/**
	 * 视频集id
	 */
	@OneToOne(optional=false, mappedBy="lesson", fetch = FetchType.LAZY)
	private VideoSet videoSet;
	/**
	 * 是否禁用
	 */
	private Boolean enable;
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
	 * 信息图
	 */
	private String graph;
	/**
	 * 信息图英
	 */
	private String graphE;
	/**
	 * 食材
	 */
	private String ingredients;
	/**
	 * 食材英
	 */
	private String ingredientsE;
	/**
	 * 图文步骤
	 */
	@ElementCollection
	private List<Step> steps;
	/**
	 * 图文步骤
	 */
	@ElementCollection
	private List<Step> stepsE;
	/**
	 * 时长，单位秒
	 */
	private Integer second;
	/**
	 * 难度
	 */
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
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
	 * @return the graph
	 */
	public String getGraph() {
		return graph;
	}
	/**
	 * @param graph the graph to set
	 */
	public void setGraph(String graph) {
		this.graph = graph;
	}
	/**
	 * @return the graphE
	 */
	public String getGraphE() {
		return graphE;
	}
	/**
	 * @param graphE the graphE to set
	 */
	public void setGraphE(String graphE) {
		this.graphE = graphE;
	}
	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	/**
	 * @return the stepsE
	 */
	public List<Step> getStepsE() {
		return stepsE;
	}
	/**
	 * @param stepsE the stepsE to set
	 */
	public void setStepsE(List<Step> stepsE) {
		this.stepsE = stepsE;
	}
	/**
	 * @return the second
	 */
	public Integer getSecond() {
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(Integer second) {
		this.second = second;
	}
	/**
	 * @return the difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * @return the ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	/**
	 * @return the ingredientsE
	 */
	public String getIngredientsE() {
		return ingredientsE;
	}
	/**
	 * @param ingredientsE the ingredientsE to set
	 */
	public void setIngredientsE(String ingredientsE) {
		this.ingredientsE = ingredientsE;
	}
	/**
	 * @return the videoSet
	 */
	public VideoSet getVideoSet() {
		return videoSet;
	}
	/**
	 * @param videoSet the videoSet to set
	 */
	public void setVideoSet(VideoSet videoSet) {
		this.videoSet = videoSet;
	}
	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	/**
	 * @return
	 */
	public LessonInfo toLessonInfo() {
		LessonInfo info = new LessonInfo();
		BeanUtils.copyProperties(this, info);
		info.setModuleId(getModule() == null ? null :getModule().getId());
		info.setVideoSetId(getVideoSet() == null ? null : getVideoSet().getId());
		return info;
	}
	
}
