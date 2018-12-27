package com.transport.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.UserCredential;

@Repository
public interface LoginRepo extends JpaRepository<UserCredential, Long> {
	public UserCredential findByUserName(String userName);
}
