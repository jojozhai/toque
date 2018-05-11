/**
 * 
 */
package com.proginn.security.rbac.dto;

/**
 * @author zhailiang
 * @since 2016年7月4日
 */
public class PasswordInfo {
	
	private String newPassword;
	
	private String oldPassword;
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
