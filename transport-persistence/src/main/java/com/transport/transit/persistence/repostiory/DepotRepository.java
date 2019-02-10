package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.DepotEntity;

@Repository
public interface DepotRepository extends JpaRepository<DepotEntity,Long> {

	//public List<DepotEntity> findByRelDivisionID(String );
}
