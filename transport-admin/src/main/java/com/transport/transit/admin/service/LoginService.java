package com.transport.transit.admin.service;

import javax.servlet.http.HttpServletRequest;

import com.transport.beans.admin.BaseResponse;
import com.transport.transit.persistence.entity.UserCredential;

public interface LoginService {

	public UserCredential findByUserName(String userName);
	
	public BaseResponse authenticateUser(UserCredential userCredential, HttpServletRequest request) throws Exception;
	
	public BaseResponse loggoffUser(String userName) throws Exception;
}
