package com.transport.transit.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="mst_user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
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

		
}
