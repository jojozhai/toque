/*
 * 项目名称：toque-core
 * 类名称: VideoSet.java
 * 创建时间: 2018年1月11日 下午12:03:32
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.VideoGroupInfo;
import com.proginn.toque.dto.VideoInfo;
import com.proginn.toque.dto.VideoSetInfo;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class VideoSet extends DomainImpl {
	
	/**
	 * 关联课程
	 */
	@OneToOne
	private Lesson lesson;
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyTime;
	/**
	 * 视频组
	 */
	@OneToMany(mappedBy = "videoSet", cascade = CascadeType.REMOVE)
	@OrderBy("sort ASC")
	private List<VideoGroup> groups = new ArrayList<>();
	
	/**
	 * @return
	 */
	public VideoSetInfo toVideoSetInfo(LanguageType languageType) {
		VideoSetInfo info = new VideoSetInfo();
		info.setCreatedTime(getCreatedTime());
		info.setId(getId());
		info.setModifyTime(getModifyTime());
		info.setName(getName());
		info.setStartWithImage(getStartWithImage());
		if(getLesson() != null) {
			info.setLessonId(getLesson().getId());
			if(LanguageType.CHINESE.equals(languageType)) {
				info.setLessonName(getLesson().getTitle());
			}else {
				info.setLessonName(getLesson().getTitleE());
			}
		}
		return info;
	}

	/**
	 * @param languageHolder
	 * @return
	 */
	public VideoSetInfo toVideoSetDetails(LanguageType languageType) {
		VideoSetInfo videoSetInfo = toVideoSetInfo(languageType);
		
		Integer rightCount = 0;
		Integer multiCount = 0;
		
		List<VideoGroupInfo> groupInfos = new ArrayList<>();
		for (VideoGroup videoGroup : groups) {
			if(VideoGroupType.JUDGE.equals(videoGroup.getType())) {
				rightCount++;
			}else if(VideoGroupType.SELECT.equals(videoGroup.getType())) {
				multiCount++;
			}
			groupInfos.add(toGroupInfo(videoGroup));
		}
				
		videoSetInfo.setRightCount(rightCount.toString());
		videoSetInfo.setMultiCount(multiCount.toString());
		videoSetInfo.setGroups(groupInfos);
		
		return videoSetInfo;
	}

	/**
	 * @param videoGroup
	 * @return
	 */
	private VideoGroupInfo toGroupInfo(VideoGroup videoGroup) {
		VideoGroupInfo groupInfo = new VideoGroupInfo();
		groupInfo.setImage(videoGroup.getImage());
		groupInfo.setRightOption(videoGroup.getRightOption());
		groupInfo.setType(videoGroup.getType());
		groupInfo.setVideos(toVideoInfos(videoGroup));
		return groupInfo;
	}

	/**
	 * @param videoGroup
	 * @return
	 */
	private List<VideoInfo> toVideoInfos(VideoGroup videoGroup) {
		List<VideoInfo> videoInfos = new ArrayList<>();
		for (Video video : videoGroup.getVideos()) {
			VideoInfo videoInfo = new VideoInfo();
			videoInfo.setUrl(video.getUrl());
			videoInfo.setNextSort(video.getNextSort() == null ? null : video.getNextSort().toString());
			videoInfos.add(videoInfo);
		}
		return videoInfos;
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
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}

	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
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
	public List<VideoGroup> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<VideoGroup> groups) {
		this.groups = groups;
	}
	
}
