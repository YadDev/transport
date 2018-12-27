package com.transport.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.admin.entity.UserCredential;
import com.transport.admin.service.LoginServiceImpl;
import com.transport.beans.admin.BaseResponse;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

@RestController
public class LoginController {
	@Autowired
	private LoginServiceImpl loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	HttpSession session = null;
	BaseResponse response = null;
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody UserCredential userCredential, HttpServletRequest request) {
		logger.info("********************Login Controller Login Method******************");
		try {
			if (userCredential != null) {
				response=loginService.authenticateUser(userCredential, request);
				
			}
			else {
				response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
				response.setRespData("Please Provide the required field.");
			}
		} catch (Exception e) {
			logger.info("Exception Login ****** " + e.getMessage());
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("Internal Server Error in Login. Please Try again!");
			
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Object> loggoff(HttpServletRequest request) throws ServletException {
		System.out.println("loggoff " + request.getParameter("SessionUserName"));
		String userName = request.getParameter("SessionUserName");
		try {
			if(userName!=null) {
				response=loginService.loggoffUser(userName);
			}else {
				response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
				response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
				response.setRespData("Please Provide the required field.");
			}
			
		}catch (Exception e) {
			logger.info("Exception Logged Off ****** " + e.getMessage());
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("Internal Server Error in log off. Please Try again!");
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
}
