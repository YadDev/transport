package com.transport.transit.etim.service;

import java.math.BigInteger;
import java.util.Date;

import com.transport.beans.etm.WaybillRequest;

public interface WaybillService {
	public WaybillRequest findByConductorAndDutyDate(BigInteger condId,Date dates);
	public boolean createWayBill(WaybillRequest waybill);
}
