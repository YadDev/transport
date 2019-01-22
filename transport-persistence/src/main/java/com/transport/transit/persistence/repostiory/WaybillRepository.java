package com.transport.transit.persistence.repostiory;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.WaybillEntity;

@Repository
public interface WaybillRepository extends JpaRepository<WaybillEntity, Long> {

	public WaybillEntity findByWaybillConductorAndDutyDate(Integer condID, Date date);
	
}
