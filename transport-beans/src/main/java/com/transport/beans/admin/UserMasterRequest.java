package com.transport.beans.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserMasterRequest {
	private Integer userId;
	private String userName;
	private String password;
	private String userType;
		

}
