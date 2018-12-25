package com.transport.admin.service;

import java.util.List;

import com.transport.admin.entity.BusStopMaster;

public interface BusStopService {

	public List<BusStopMaster> loadAllBusStops();
	public BusStopMaster getBusStopDetails(String StopCode);
	
}
