/*
 * 项目名称：toque-core
 * 类名称: VideoGroupInfo.java
 * 创建时间: 2018年1月11日 下午1:40:34
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

import java.util.List;

import com.proginn.toque.domain.VideoGroupType;

/**
 * @author zhailiang@jd.com
 *
 */
public class VideoGroupInfo {
	
	/**
	 * 交互图
	 */
	private String image;
	/**
	 * 类型
	 */
	private VideoGroupType type;
	/**
	 * 对错型，哪个是对的，AorB
	 */
	private String rightOption;
	/**
	 * 包含的视频
	 */
	private List<VideoInfo> videos;
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
	/**
	 * @return the videos
	 */
	public List<VideoInfo> getVideos() {
		return videos;
	}
	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<VideoInfo> videos) {
		this.videos = videos;
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
	
}
