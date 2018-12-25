package com.transport.admin.service;

import javax.servlet.http.HttpServletRequest;

import com.transport.admin.entity.UserCredential;
import com.transport.beans.admin.BaseResponse;

public interface LoginService {

	public UserCredential findByUserName(String userName);
	
	public BaseResponse authenticateUser(UserCredential userCredential, HttpServletRequest request) throws Exception;
	
	public BaseResponse loggoffUser(String userName) throws Exception;
}
