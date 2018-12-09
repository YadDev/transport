package com.transport.beans.admin;

public class UserCredential {
	private Integer getUserId;	
	private String userName;
	private String password;
	
	public Integer getGetUserId() {
		return getUserId;
	}
	public void setGetUserId(Integer getUserId) {
		this.getUserId = getUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserCredential [getUserId=" + getUserId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
