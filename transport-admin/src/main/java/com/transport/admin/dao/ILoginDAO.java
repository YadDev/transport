package com.transport.admin.dao;

import com.transport.beans.admin.UserCredential;

public interface ILoginDAO {

	public UserCredential findByUserName(String userName);
}
