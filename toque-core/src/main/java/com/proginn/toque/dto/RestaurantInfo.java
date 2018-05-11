/**
 * 
 */
package com.proginn.toque.dto;

import java.util.Date;

import com.proginn.toque.domain.RestaurantLevel;

/**
 * @author zhailiang
 *
 */
public class RestaurantInfo {

	private Long id;
	/**
	 * 邀请码
	 */
	private String inviteCode;
	/**
	 * 餐厅名称
	 */
	private String name;
	/**
	 * 餐厅类型
	 */
	private String type;
	/**
	 * 菜式类型
	 */
	private String dishType;
	/**
	 * 有效标识
	 */
	private Boolean enable;
	/**
	 * 特权等级
	 */
	private RestaurantLevel level;
	/**
	 * 团队人数上限
	 */
	private Integer teamLimit;
	/**
	 * 特权到期时间
	 */
	private Date prerogativeEndTime;
	/**
	 * 是否付费
	 */
	private Boolean pay;
	/**
	 * 付费等级
	 */
	private RestaurantLevel payLevel;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the inviteCode
	 */
	public String getInviteCode() {
		return inviteCode;
	}

	/**
	 * @param inviteCode the inviteCode to set
	 */
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the dishType
	 */
	public String getDishType() {
		return dishType;
	}

	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the level
	 */
	public RestaurantLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(RestaurantLevel level) {
		this.level = level;
	}

	/**
	 * @return the teamLimit
	 */
	public Integer getTeamLimit() {
		return teamLimit;
	}

	/**
	 * @param teamLimit the teamLimit to set
	 */
	public void setTeamLimit(Integer teamLimit) {
		this.teamLimit = teamLimit;
	}

	/**
	 * @return the prerogativeEndTime
	 */
	public Date getPrerogativeEndTime() {
		return prerogativeEndTime;
	}

	/**
	 * @param prerogativeEndTime the prerogativeEndTime to set
	 */
	public void setPrerogativeEndTime(Date prerogativeEndTime) {
		this.prerogativeEndTime = prerogativeEndTime;
	}

	/**
	 * @return the pay
	 */
	public Boolean getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(Boolean pay) {
		this.pay = pay;
	}

	/**
	 * @return the payLevel
	 */
	public RestaurantLevel getPayLevel() {
		return payLevel;
	}

	/**
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(RestaurantLevel payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
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
	
}
