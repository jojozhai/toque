/*
 * 项目名称：toque-core
 * 类名称: VideoSetService.java
 * 创建时间: 2018年1月4日 上午10:58:19
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.Option;
import com.proginn.toque.dto.VideoSetCondition;
import com.proginn.toque.dto.VideoSetInfo;

/**
 * @author zhailiang@jd.com
 *
 */
public interface VideoSetService {
	
	/**
	 * 创建视频集
	 * @param info
	 * @return
	 */
	VideoSetInfo create(VideoSetInfo info);
	/**
	 * 修改视频集信息
	 * @param info
	 * @return
	 */
	VideoSetInfo update(VideoSetInfo info);
	/**
	 * 删除视频集
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 分页查询视频集信息
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<VideoSetInfo> query(VideoSetCondition condition, Pageable pageable, LanguageType languageType);
	/**
	 * 获取视频集信息
	 * @param id
	 * @return
	 */
	VideoSetInfo get(Long id, LanguageType languageType);
	/**
	 * @return
	 */
	List<Option> findAll();

}
