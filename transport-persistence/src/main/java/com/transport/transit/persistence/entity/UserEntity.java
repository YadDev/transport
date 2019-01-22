package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_user database table.
 * 
 */
@Entity
@Table(name="mst_user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="client_id")
	private int clientId;

	@Column(name="user_code")
	private String userCode;

	@Column(name="user_created_by")
	private int userCreatedBy;

	@Column(name="user_last_updated")
	private Timestamp userLastUpdated;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_pass")
	private String userPass;

	@Column(name="user_role_id")
	private int userRoleId;

	@Column(name="user_status_code")
	private int userStatusCode;

	public UserEntity() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(int userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public Timestamp getUserLastUpdated() {
		return this.userLastUpdated;
	}

	public void setUserLastUpdated(Timestamp userLastUpdated) {
		this.userLastUpdated = userLastUpdated;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserStatusCode() {
		return this.userStatusCode;
	}

	public void setUserStatusCode(int userStatusCode) {
		this.userStatusCode = userStatusCode;
	}

}