/*
 * 项目名称：toque-core
 * 类名称: LessonServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:24:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Lesson;
import com.proginn.toque.domain.VideoSet;
import com.proginn.toque.dto.LessonCondition;
import com.proginn.toque.dto.LessonInfo;
import com.proginn.toque.repository.LessonRepository;
import com.proginn.toque.repository.ModuleRepository;
import com.proginn.toque.repository.VideoSetRepository;
import com.proginn.toque.repository.spec.LessonSpec;
import com.proginn.toque.service.LessonService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private VideoSetRepository videoSetRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#create(com.proginn.toque.dto.LessonInfo)
	 */
	@Override
	public LessonInfo create(LessonInfo info) {
		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(info, lesson);
		lesson.setModule(moduleRepository.getOne(info.getModuleId()));
		info.setId(lessonRepository.save(lesson).getId());
		
		VideoSet videoSet = videoSetRepository.findOne(new Long(info.getVideoSetId()));
		if(videoSet.getLesson() != null) {
			throw new RuntimeException("所选视频集已绑定其他课程");
		}
		videoSet.setLesson(lesson);
		
		lesson.setEnable(true);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#update(com.proginn.toque.dto.LessonInfo)
	 */
	@Override
	public LessonInfo update(LessonInfo info) {
		
		Lesson lesson = lessonRepository.findOne(info.getId());
		
		BeanUtils.copyProperties(info, lesson);
		lesson.setModule(moduleRepository.getOne(info.getModuleId()));
		
		if(!info.getVideoSetId().equals(lesson.getVideoSet().getId())) {
			VideoSet videoSet = videoSetRepository.findOne(info.getVideoSetId());
			if(videoSet.getLesson() != null) {
				throw new RuntimeException("所选视频集已绑定其他课程");
			}
			lesson.getVideoSet().setLesson(null);
			lesson.setVideoSet(videoSet);
			videoSet.setLesson(lesson);
		}
		
		
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		
		Lesson lesson = lessonRepository.findOne(id);
		VideoSet videoSet = videoSetRepository.findOne(lesson.getVideoSet().getId());
		videoSet.setLesson(null);
		videoSetRepository.save(videoSet);
		lesson.setVideoSet(null);
		lessonRepository.delete(lesson);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#query(com.proginn.toque.dto.LessonCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<LessonInfo> query(LessonCondition condition, Pageable pageable) {
		Page<Lesson> lessons = lessonRepository.findAll(new LessonSpec(condition), pageable);
		return QueryResultConverter.convert(lessons, pageable, (Lesson) -> Lesson.toLessonInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#get(java.lang.Long)
	 */
	@Override
	public LessonInfo get(Long id) {
		return lessonRepository.findOne(id).toLessonInfo();
	}
	
	@Override
	public void enable(Long id) {
		Lesson lesson = lessonRepository.findOne(id);
		lesson.setEnable(true);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.LessonService#disable(java.lang.Long)
	 */
	@Override
	public void disable(Long id) {
		Lesson lesson = lessonRepository.findOne(id);
		lesson.setEnable(false);
	}

}
