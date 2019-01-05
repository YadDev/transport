package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.MenuMaster;

@Repository
public interface MenuRepo extends JpaRepository<MenuMaster,Long> {
		
}
