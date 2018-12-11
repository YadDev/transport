package com.transport.admin.service;

import javax.servlet.http.HttpServletRequest;

import com.transport.admin.entity.UserCredential;
import com.transport.beans.admin.RespResult;

public interface LoginService {

	public UserCredential findByUserName(String userName);
	
	public RespResult authenticateUser(UserCredential userCredential, HttpServletRequest request) throws Exception;
	
	public RespResult loggoffUser(String userName) throws Exception;
}
