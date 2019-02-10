package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.transit.persistence.entity.RouteTypeEntity;

public interface RouteTypeRepository extends JpaRepository<RouteTypeEntity, Long> {

	
}
