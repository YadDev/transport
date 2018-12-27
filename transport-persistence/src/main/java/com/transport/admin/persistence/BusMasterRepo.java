package com.transport.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.BusStopMaster;

@Repository
public interface BusMasterRepo extends JpaRepository<BusStopMaster, Long> {
	public BusStopMaster findByBusStopCode(String code);

}
