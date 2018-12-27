package com.transport.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.MenuMaster;

@Repository
public interface MenuRepo extends JpaRepository<MenuMaster,Long> {
	
}
