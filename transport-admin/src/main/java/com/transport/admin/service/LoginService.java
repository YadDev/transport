package com.transport.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.admin.dao.LoginDAO;
import com.transport.beans.admin.UserCredential;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private LoginDAO loginDAO;
	@Override
	public UserCredential findByUserName(String userName) {
		return loginDAO.findByUserName(userName);
	}

}
