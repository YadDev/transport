package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
		
}
