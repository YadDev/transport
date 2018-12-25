package com.transport.admin.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.UserCredential;

@Repository
public interface LoginRepo extends CrudRepository<UserCredential, Long> {
	public UserCredential findByUserName(String userName);
}
