package com.transport.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_user")
public class UserCredential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String user;
	
	@Column(name="user_code")
	private String userName;
	
	@Column(name="user_pass")
	private String password;
	
	
	@Column(name="user_role_id")
	private Integer roleID;
	
	@Column(name="user_status_code")
	private Integer userStatus;
	
	@Column(name="client_id")
	private Integer clientID;
	
	@Column(name="user_created_by")
	private Integer createdBy;
	
	@Column(name="user_last_updated")
	private Timestamp updatedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "UserCredential [userId=" + userId + ", user=" + user + ", userName=" + userName + ", password="
				+ password + ", roleID=" + roleID + ", userStatus=" + userStatus + ", clientID=" + clientID
				+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
}
