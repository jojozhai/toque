/*
 * 项目名称：toque-core
 * 类名称: Praise.java
 * 创建时间: 2018年1月12日 下午6:02:51
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.proginn.security.i18n.LanguageType;
import com.proginn.toque.dto.PraiseInfo;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class Praise extends DomainImpl {

	/**
	 * 课程
	 */
	@ManyToOne
	private Lesson lesson;
	/**
	 * 用户
	 */
	@ManyToOne
	private User user;
	/**
	 * 赞
	 */
	private Boolean praise;
	/**
	 * 评价内容
	 */
	private String content;
	
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the praise
	 */
	public Boolean getPraise() {
		return praise;
	}
	/**
	 * @param praise the praise to set
	 */
	public void setPraise(Boolean praise) {
		this.praise = praise;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return
	 */
	public PraiseInfo toPraiseInfo(LanguageType languageType) {
		PraiseInfo info = new PraiseInfo();
		BeanUtils.copyProperties(this, info);
		if(info.getPraise()) {
			info.setContent("点赞");
		}else {
			if(StringUtils.isBlank(info.getContent())) {
				info.setContent("点踩");
			}
		}
		info.setLessonId(getLesson().getId());
		if(LanguageType.CHINESE.equals(languageType)) {
			info.setLessonName(getLesson().getTitle());
		}else {
			info.setLessonName(getLesson().getTitleE());
		}
		info.setUserId(getUser().getId());
		info.setUsername(getUser().getPhoneOrEmail());
		return info;
	}
	
}
