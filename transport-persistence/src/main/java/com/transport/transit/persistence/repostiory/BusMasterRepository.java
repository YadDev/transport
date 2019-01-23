package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.BusStopEntity;

@Repository
public interface BusMasterRepository extends JpaRepository<BusStopEntity, Long> {
	public BusStopEntity findByBusStopCode(String code);
	public void deleteByBusStopCode(String busStopCode);

}
