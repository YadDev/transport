package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.BusStopMaster;

@Repository
public interface BusMasterRepo extends JpaRepository<BusStopMaster, Long> {
	public BusStopMaster findByBusStopCode(String code);
	public void deleteByBusStopCode(String busStopCode);

}
