package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.UserEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findByUserName(String userName);
}
