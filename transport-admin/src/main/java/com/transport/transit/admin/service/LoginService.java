package com.transport.transit.admin.service;

import javax.servlet.http.HttpServletRequest;

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.admin.UserMasterRequest;

public interface LoginService {

	public UserMasterRequest findByUserName(String userName);
	
	public BaseResponse authenticateUser(UserMasterRequest userCredential, HttpServletRequest request) throws Exception;
	
	public BaseResponse loggoffUser(String userName) throws Exception;
}
