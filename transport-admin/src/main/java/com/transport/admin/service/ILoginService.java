package com.transport.admin.service;

import com.transport.beans.admin.UserCredential;

public interface ILoginService {

	public UserCredential findByUserName(String userName);
}
