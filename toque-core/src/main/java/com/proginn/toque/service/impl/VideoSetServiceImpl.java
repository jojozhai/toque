/*
 * 项目名称：toque-core
 * 类名称: VideoSetServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:24:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.i18n.LanguageType;
import com.proginn.security.rbac.repository.support.AbstractDomain2InfoConverter;
import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Video;
import com.proginn.toque.domain.VideoGroup;
import com.proginn.toque.domain.VideoSet;
import com.proginn.toque.dto.Option;
import com.proginn.toque.dto.VideoGroupInfo;
import com.proginn.toque.dto.VideoInfo;
import com.proginn.toque.dto.VideoSetCondition;
import com.proginn.toque.dto.VideoSetInfo;
import com.proginn.toque.repository.VideoGroupRepository;
import com.proginn.toque.repository.VideoRepository;
import com.proginn.toque.repository.VideoSetRepository;
import com.proginn.toque.repository.spec.VideoSetSpec;
import com.proginn.toque.service.VideoSetService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class VideoSetServiceImpl implements VideoSetService {
	
	@Autowired
	private VideoSetRepository videoSetRepository;
	
	@Autowired
	private VideoGroupRepository videoGroupRepository;
	
	@Autowired
	private VideoRepository videoRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.VideoSetService#create(com.proginn.toque.dto.VideoSetInfo)
	 */
	@Override
	public VideoSetInfo create(VideoSetInfo videoSetInfo) {
		createVideos(videoSetInfo, createVideoGroups(videoSetInfo, createVidoSet(videoSetInfo)));
		return videoSetInfo;
	}

	/**
	 * @param videoSetInfo
	 * @param groups
	 */
	private void createVideos(VideoSetInfo videoSetInfo, List<VideoGroup> groups) {
		for (int i = 0; i < videoSetInfo.getGroups().size(); i++) {
			VideoGroupInfo groupInfo = videoSetInfo.getGroups().get(i);
			for (int j = 0; j < groupInfo.getVideos().size(); j++) {
				VideoInfo videoInfo = groupInfo.getVideos().get(j);
				
				Video video = new Video();
				video.setGroup(groups.get(i));
				if(StringUtils.isNotBlank(videoInfo.getNextSort())) {
					VideoGroup nextGroup = null; 
					try {nextGroup = groups.get(new Integer(videoInfo.getNextSort()));} catch (IndexOutOfBoundsException e) {}
					video.setNext(nextGroup);
					video.setNextSort(new Integer(videoInfo.getNextSort()));
				}
				video.setSort(j);
				video.setUrl(videoInfo.getUrl());
				videoRepository.save(video);
			}
		}
	}

	/**
	 * @param videoSetInfo
	 * @param videoSet
	 * @return
	 */
	private List<VideoGroup> createVideoGroups(VideoSetInfo videoSetInfo, VideoSet videoSet) {
		List<VideoGroup> groups = new ArrayList<>();
		for (int i = 0; i < videoSetInfo.getGroups().size(); i++) {
			VideoGroupInfo groupInfo = videoSetInfo.getGroups().get(i);
			
			VideoGroup videoGroup = new VideoGroup();
			videoGroup.setImage(groupInfo.getImage());
			videoGroup.setRightOption(groupInfo.getRightOption());
			videoGroup.setSort(i);
			videoGroup.setType(groupInfo.getType());
			videoGroup.setVideoSet(videoSet);
			videoGroupRepository.save(videoGroup);
			
			groups.add(videoGroup);
		}
		return groups;
	}

	/**
	 * @param videoSetInfo
	 * @return
	 */
	private VideoSet createVidoSet(VideoSetInfo videoSetInfo) {
		VideoSet videoSet = new VideoSet();
		videoSet.setName(videoSetInfo.getName());
		videoSet.setStartWithImage(videoSetInfo.getStartWithImage());
		videoSet.setModifyTime(new Date());
		videoSetRepository.save(videoSet);
		return videoSet;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.VideoSetService#update(com.proginn.toque.dto.VideoSetInfo)
	 */
	@Override
	public VideoSetInfo update(VideoSetInfo videoSetInfo) {
		VideoSet videoSet = videoSetRepository.findOne(videoSetInfo.getId());
		videoSet.setName(videoSetInfo.getName());
		videoSet.setModifyTime(new Date());
		videoGroupRepository.delete(videoSet.getGroups());
		createVideos(videoSetInfo, createVideoGroups(videoSetInfo, videoSet));
		return videoSetInfo;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.VideoSetService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		videoSetRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.VideoSetService#query(com.proginn.toque.dto.VideoSetCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<VideoSetInfo> query(VideoSetCondition condition, Pageable pageable, LanguageType languageType) {
		Page<VideoSet> videoSets = videoSetRepository.findAll(new VideoSetSpec(condition), pageable);
		return QueryResultConverter.convert(videoSets, pageable, (VideoSet) -> VideoSet.toVideoSetInfo(languageType));
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.VideoSetService#get(java.lang.Long)
	 */
	@Override
	public VideoSetInfo get(Long id, LanguageType languageType) {
		return videoSetRepository.findOne(id).toVideoSetDetails(languageType);
	}
	
	/* (non-Javadoc)
	 * @see com.proginn.toque.service.ModuleService#findAll()
	 */
	@Override
	public List<Option> findAll() {
		return QueryResultConverter.convert(videoSetRepository.findAll(), new AbstractDomain2InfoConverter<VideoSet, Option>() {
			@Override
			protected void doConvert(VideoSet domain, Option info) throws Exception {
				info.setName(domain.getName());
				info.setValue(domain.getId().toString());
			}
		});
	}

}
