package com.transport.transit.etim.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.beans.etm.WaybillRequest;
import com.transport.transit.persistence.entity.WaybillEntity;
import com.transport.transit.persistence.repostiory.WaybillRepository;

@Service
@Transactional
public class WaybillServiceImpl implements WaybillService{

	@Autowired
	private WaybillRepository waybillRepository;
	
	@Override
	public WaybillRequest findByConductorAndDutyDate(BigInteger condId,Date dates) throws DataAccessException, NullPointerException {
		System.out.println("Conductor Id "+condId);
		WaybillRequest wayBill=new WaybillRequest();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		WaybillEntity waybillEntity=waybillRepository.findByWaybillConductorAndDutyDate(condId, sdf.format(dates));
		wayBill.setWaybillConductor(waybillEntity.getWaybillConductor());
		wayBill.setWaybillNumber(waybillEntity.getWaybillNumber());
		wayBill.setDutyDate(waybillEntity.getDutyDate());
		System.out.println(wayBill.toString());
		return wayBill;
	}

	@Override
	
	public boolean createWayBill(WaybillRequest waybill) {
		
		WaybillEntity entity=new WaybillEntity();
		
		entity.setWaybillNumber(waybill.getWaybillNumber());
		entity.setWaybillDepot(waybill.getWaybillDepot());
		entity.setWaybillVehicle(waybill.getWaybillVehicle());
		entity.setRelBusTypeId(waybill.getRelBusTypeId());
		entity.setWaybillDriver(waybill.getWaybillDriver());
		entity.setWaybillSupDriver(waybill.getWaybillSupDriver());
		entity.setWaybillType(waybill.getWaybillType());
		entity.setRelExtraReason(waybill.getRelExtraReason());
		entity.setNoOfDays(waybill.getNoOfDays());
		entity.setDutyDate(waybill.getDutyDate());
		entity.setRelDutyAllocationId(waybill.getRelDutyAllocationId());
		entity.setRelEtimNo(waybill.getRelEtimNo());
		entity.setRelVersionId(waybill.getRelVersionId());
		entity.setRelWaybillStatusId(waybill.getRelWaybillStatusId());
		entity.setScheduleTrip(waybill.getScheduleTrip());
		entity.setActualTrip(waybill.getActualTrip());
		entity.setScheduleKm(waybill.getActualKm());
		entity.setActualKm(waybill.getActualKm());
		entity.setIssueClerk(waybill.getIssueClerk());
		entity.setCashCollectClerk(waybill.getCashCollectClerk());
		entity.setWaybillCollectClerk(waybill.getWaybillCollectClerk());
		
		
		entity=waybillRepository.save(entity);
		
		System.out.println("Record After Insertion "+entity.getWaybillId());
		
		
		return true;
	}

}

