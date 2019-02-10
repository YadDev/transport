package com.transport.transit.persistence.repostiory;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.WaybillEntity;

@Repository
public interface WaybillRepository extends JpaRepository<WaybillEntity, Long> {

	final String GET_WAYBILL_COND_DUTY_DATE="SELECT * FROM tsn_waybill WHERE waybillConductor=? and dutyDate=?";
	@Query(value = GET_WAYBILL_COND_DUTY_DATE , nativeQuery = true)
	public WaybillEntity findByWaybillConductorAndDutyDate(BigInteger condID, String date);
	
}
