package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.transit.persistence.entity.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {

}
