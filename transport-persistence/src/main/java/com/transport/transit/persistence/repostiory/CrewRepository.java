package com.transport.transit.persistence.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.transit.persistence.entity.CrewEntity;

public interface CrewRepository extends JpaRepository<CrewEntity, Long> {
	public List<CrewEntity> findByRelCrewTypeAndOrgUniqueId(Integer crewType,String orgID);
	public CrewEntity findByOrgUniqueId(String uniqueCrewID);
}
