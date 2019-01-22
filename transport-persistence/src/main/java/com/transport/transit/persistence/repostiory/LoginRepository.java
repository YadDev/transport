package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.UserCredential;

@Repository
public interface LoginRepository extends JpaRepository<UserCredential, Long> {
	public UserCredential findByUserName(String userName);
}
