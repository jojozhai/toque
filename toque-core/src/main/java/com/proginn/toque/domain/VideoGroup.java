/*
 * 项目名称：toque-core
 * 类名称: VideoGroup.java
 * 创建时间: 2018年1月11日 下午12:02:56
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class VideoGroup extends DomainImpl {
	
	/**
	 * 所属视频集
	 */
	@ManyToOne
	private VideoSet videoSet;
	/**
	 * 交互图
	 */
	private String image;
	/**
	 * 组的顺序号
	 */
	private Integer sort;
	/**
	 * 群组类型
	 */
	@Enumerated(EnumType.STRING)
	private VideoGroupType type;
	/**
	 * 类型为对错是，哪个是对的，AorB
	 */
	private String rightOption;
	/**
	 * 视频
	 */
	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
	@OrderBy("sort ASC")
	private List<Video> videos = new ArrayList<>();
	
	/**
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
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
	 * @return the rightOption
	 */
	public String getRightOption() {
		return rightOption;
	}

	/**
	 * @param rightOption the rightOption to set
	 */
	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
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

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return the type
	 */
	public VideoGroupType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(VideoGroupType type) {
		this.type = type;
	}

	
}
