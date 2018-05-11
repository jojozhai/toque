/*
 * 项目名称：toque-core
 * 类名称: VideoSetInfo.java
 * 创建时间: 2018年1月11日 下午1:36:37
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;
import java.util.List;

/**
 * @author zhailiang@jd.com
 *
 */
public class VideoSetInfo {
	
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 关联课程
	 */
	private Long lessonId;
	/**
	 * 关联课程
	 */
	private String lessonName;
	/**
	 * 视频集名称
	 */
	private String name;
	/**
	 * 是否是图片启动
	 */
	private Boolean startWithImage;
	/**
	 * 最后修改时间
	 */
	private Date modifyTime;
	/**
	 * 包含的视频组
	 */
	private List<VideoGroupInfo> groups;
	/**
	 * 对错型的总数
	 */
	private String rightCount;
	/**
	 * 多选型的总数
	 */
	private String multiCount;
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
	/**
	 * @return the lessonId
	 */
	public Long getLessonId() {
		return lessonId;
	}
	/**
	 * @param lessonId the lessonId to set
	 */
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}
	/**
	 * @return the lessonName
	 */
	public String getLessonName() {
		return lessonName;
	}
	/**
	 * @param lessonName the lessonName to set
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the startWithImage
	 */
	public Boolean getStartWithImage() {
		return startWithImage;
	}
	/**
	 * @param startWithImage the startWithImage to set
	 */
	public void setStartWithImage(Boolean startWithImage) {
		this.startWithImage = startWithImage;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the groups
	 */
	public List<VideoGroupInfo> getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<VideoGroupInfo> groups) {
		this.groups = groups;
	}
	/**
	 * @return the rightCount
	 */
	public String getRightCount() {
		return rightCount;
	}
	/**
	 * @param rightCount the rightCount to set
	 */
	public void setRightCount(String rightCount) {
		this.rightCount = rightCount;
	}
	/**
	 * @return the multiCount
	 */
	public String getMultiCount() {
		return multiCount;
	}
	/**
	 * @param multiCount the multiCount to set
	 */
	public void setMultiCount(String multiCount) {
		this.multiCount = multiCount;
	}
}
