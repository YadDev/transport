package com.transport.admin.persistence;

import com.transport.admin.entity.UserCredential;

public interface LoginDAO {

	public UserCredential findByUserName(String userName);
}
