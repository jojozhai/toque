/*
 * 项目名称：toque-core
 * 类名称: LessonStatInfo.java
 * 创建时间: 2018年1月18日 上午10:58:43
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.dto;

/**
 * @author zhailiang@jd.com
 *
 */
public class LessonStatInfo {
	
	/**
	 * 课程
	 */
	private String lessonTitle;
	/**
	 * 课程
	 */
	private String lessonTitleE;
	/**
	 * 所选时间段内，课程播放总次数，课程列表以该字段的值倒序排列
	 */
	private Long playPv;
	/**
	 * 所选时间段内，按用户去重后的课程播放总次数
	 */
	private Long playUv;
	/**
	 * 所选时间段内，课程播放的总时长/课程播放总次数
	 */
	private String avgTime;
	/**
	 * 所选时间段内，课程播放完毕的次数（播放完交互结果为“无交互”的视频，则认为课程播放完毕，即课程学习完毕）
	 */
	private Long finished;
	/**
	 * 所选时间段内，课程被主厨成功指派的次数
	 */
	private Long assigned;
	/**
	 * 所选时间段内，课程被点赞的次数
	 */
	private Long praised;
	/**
	 * 所选时间段内，课程被点踩的次数
	 */
	private Long criticism;
	
	/**
	 * @return the lessonTitle
	 */
	public String getLessonTitle() {
		return lessonTitle;
	}
	/**
	 * @param lessonTitle the lessonTitle to set
	 */
	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}
	/**
	 * @return the lessonTitleE
	 */
	public String getLessonTitleE() {
		return lessonTitleE;
	}
	/**
	 * @param lessonTitleE the lessonTitleE to set
	 */
	public void setLessonTitleE(String lessonTitleE) {
		this.lessonTitleE = lessonTitleE;
	}
	/**
	 * @return the playPv
	 */
	public Long getPlayPv() {
		return playPv;
	}
	/**
	 * @param playPv the playPv to set
	 */
	public void setPlayPv(Long playPv) {
		this.playPv = playPv;
	}
	/**
	 * @return the playUv
	 */
	public Long getPlayUv() {
		return playUv;
	}
	/**
	 * @param playUv the playUv to set
	 */
	public void setPlayUv(Long playUv) {
		this.playUv = playUv;
	}
	/**
	 * @return the avgTime
	 */
	public String getAvgTime() {
		return avgTime;
	}
	/**
	 * @param avgTime the avgTime to set
	 */
	public void setAvgTime(String avgTime) {
		this.avgTime = avgTime;
	}
	/**
	 * @return the finished
	 */
	public Long getFinished() {
		return finished;
	}
	/**
	 * @param finished the finished to set
	 */
	public void setFinished(Long finished) {
		this.finished = finished;
	}
	/**
	 * @return the assigned
	 */
	public Long getAssigned() {
		return assigned;
	}
	/**
	 * @param assigned the assigned to set
	 */
	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}
	/**
	 * @return the praised
	 */
	public Long getPraised() {
		return praised;
	}
	/**
	 * @param praised the praised to set
	 */
	public void setPraised(Long praised) {
		this.praised = praised;
	}
	/**
	 * @return the criticism
	 */
	public Long getCriticism() {
		return criticism;
	}
	/**
	 * @param criticism the criticism to set
	 */
	public void setCriticism(Long criticism) {
		this.criticism = criticism;
	}

}
