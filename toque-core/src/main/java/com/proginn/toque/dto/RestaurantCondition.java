/**
 * 
 */
package com.proginn.toque.dto;

/**
 * @author zhailiang
 *
 */
public class RestaurantCondition {
	
	private String name;
	
	private Boolean pay;

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
	
}
