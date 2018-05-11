/*
 * 项目名称：toque-core
 * 类名称: LessonStat.java
 * 创建时间: 2018年1月18日 上午10:11:51
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zhailiang@jd.com
 *
 */
@Entity
public class LessonStat extends DomainImpl {
	
	/**
	 * 统计日期
	 */
	@Temporal(TemporalType.DATE)
	private Date date;
	/**
	 * 课程
	 */
	@ManyToOne
	private Lesson lesson;
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
	private BigDecimal avgTime;
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
	
	private Long playPvWeek;
	
	private Long playUvWeek;
	
	private BigDecimal avgTimeWeek;
	
	private Long finishedWeek;
	
	private Long assignedWeek;
	
	private Long praisedWeek;
	
	private Long criticismWeek;
	
	private Long playPvTotal;
	
	private Long playUvTotal;
	
	private BigDecimal avgTimeTotal;
	
	private Long finishedTotal;
	
	private Long assignedTotal;
	
	private Long praisedTotal;
	
	private Long criticismTotal;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	public BigDecimal getAvgTime() {
		return avgTime;
	}

	/**
	 * @param avgTime the avgTime to set
	 */
	public void setAvgTime(BigDecimal avgTime) {
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

	/**
	 * @return the playPvWeek
	 */
	public Long getPlayPvWeek() {
		return playPvWeek;
	}

	/**
	 * @param playPvWeek the playPvWeek to set
	 */
	public void setPlayPvWeek(Long playPvWeek) {
		this.playPvWeek = playPvWeek;
	}

	/**
	 * @return the playUvWeek
	 */
	public Long getPlayUvWeek() {
		return playUvWeek;
	}

	/**
	 * @param playUvWeek the playUvWeek to set
	 */
	public void setPlayUvWeek(Long playUvWeek) {
		this.playUvWeek = playUvWeek;
	}

	/**
	 * @return the avgTimeWeek
	 */
	public BigDecimal getAvgTimeWeek() {
		return avgTimeWeek;
	}

	/**
	 * @param avgTimeWeek the avgTimeWeek to set
	 */
	public void setAvgTimeWeek(BigDecimal avgTimeWeek) {
		this.avgTimeWeek = avgTimeWeek;
	}

	/**
	 * @return the finishedWeek
	 */
	public Long getFinishedWeek() {
		return finishedWeek;
	}

	/**
	 * @param finishedWeek the finishedWeek to set
	 */
	public void setFinishedWeek(Long finishedWeek) {
		this.finishedWeek = finishedWeek;
	}

	/**
	 * @return the assignedWeek
	 */
	public Long getAssignedWeek() {
		return assignedWeek;
	}

	/**
	 * @param assignedWeek the assignedWeek to set
	 */
	public void setAssignedWeek(Long assignedWeek) {
		this.assignedWeek = assignedWeek;
	}

	/**
	 * @return the praisedWeek
	 */
	public Long getPraisedWeek() {
		return praisedWeek;
	}

	/**
	 * @param praisedWeek the praisedWeek to set
	 */
	public void setPraisedWeek(Long praisedWeek) {
		this.praisedWeek = praisedWeek;
	}

	/**
	 * @return the criticismWeek
	 */
	public Long getCriticismWeek() {
		return criticismWeek;
	}

	/**
	 * @param criticismWeek the criticismWeek to set
	 */
	public void setCriticismWeek(Long criticismWeek) {
		this.criticismWeek = criticismWeek;
	}

	/**
	 * @return the playPvTotal
	 */
	public Long getPlayPvTotal() {
		return playPvTotal;
	}

	/**
	 * @param playPvTotal the playPvTotal to set
	 */
	public void setPlayPvTotal(Long playPvTotal) {
		this.playPvTotal = playPvTotal;
	}

	/**
	 * @return the playUvTotal
	 */
	public Long getPlayUvTotal() {
		return playUvTotal;
	}

	/**
	 * @param playUvTotal the playUvTotal to set
	 */
	public void setPlayUvTotal(Long playUvTotal) {
		this.playUvTotal = playUvTotal;
	}

	/**
	 * @return the avgTimeTotal
	 */
	public BigDecimal getAvgTimeTotal() {
		return avgTimeTotal;
	}

	/**
	 * @param avgTimeTotal the avgTimeTotal to set
	 */
	public void setAvgTimeTotal(BigDecimal avgTimeTotal) {
		this.avgTimeTotal = avgTimeTotal;
	}

	/**
	 * @return the finishedTotal
	 */
	public Long getFinishedTotal() {
		return finishedTotal;
	}

	/**
	 * @param finishedTotal the finishedTotal to set
	 */
	public void setFinishedTotal(Long finishedTotal) {
		this.finishedTotal = finishedTotal;
	}

	/**
	 * @return the assignedTotal
	 */
	public Long getAssignedTotal() {
		return assignedTotal;
	}

	/**
	 * @param assignedTotal the assignedTotal to set
	 */
	public void setAssignedTotal(Long assignedTotal) {
		this.assignedTotal = assignedTotal;
	}

	/**
	 * @return the praisedTotal
	 */
	public Long getPraisedTotal() {
		return praisedTotal;
	}

	/**
	 * @param praisedTotal the praisedTotal to set
	 */
	public void setPraisedTotal(Long praisedTotal) {
		this.praisedTotal = praisedTotal;
	}

	/**
	 * @return the criticismTotal
	 */
	public Long getCriticismTotal() {
		return criticismTotal;
	}

	/**
	 * @param criticismTotal the criticismTotal to set
	 */
	public void setCriticismTotal(Long criticismTotal) {
		this.criticismTotal = criticismTotal;
	}
	
}
