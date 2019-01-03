package com.transport.transit.etm.service;

import java.util.Date;

import com.transport.transit.persistence.entity.WaybillEntity;

public interface WaybillService {
	public WaybillEntity findByConductorAndDutyDate(Integer condId,Date dates);
}
