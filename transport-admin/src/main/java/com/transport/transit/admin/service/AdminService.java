package com.transport.transit.admin.service;

import java.util.List;

import com.transport.beans.admin.CreateMenuRequest;
import com.transport.transit.persistence.entity.BusStopMaster;


public interface AdminService {

	public List<CreateMenuRequest> loadMenuMaster(Integer roleID);
	public boolean createNewMenu(CreateMenuRequest createMenuRequest);
	public List<BusStopMaster> loadAllBusStops();
	public BusStopMaster getBusStopDetails(String StopCode);
	public BusStopMaster createBusStop(BusStopMaster busStopMaster);
	public BusStopMaster updateBusStop(BusStopMaster busStopMaster);

	
}
