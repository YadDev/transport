package com.transport.transit.etm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.transit.persistence.entity.WaybillEntity;
import com.transport.transit.persistence.repostiory.WaybillRepository;

@Service
public class WaybillServiceImpl implements WaybillService{

	@Autowired
	private WaybillRepository waybill;
	@Override
	public WaybillEntity findByConductorAndDutyDate(Integer condId,Date dates) {				
		return waybill.findByWaybillConductorAndDutyDate(1, new Date());
	}

}
