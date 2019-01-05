package com.transport.transit.admin.service;

import java.util.List;

import com.transport.transit.persistence.entity.BusStopMaster;
import com.transport.transit.persistence.entity.MenuMaster;


public interface AdminService {

	public List<MenuMaster> loadMenuMaster(Integer roleID);
	public MenuMaster createNewMenu(MenuMaster menu);
	public List<BusStopMaster> loadAllBusStops();
	public BusStopMaster getBusStopDetails(String StopCode);
	public BusStopMaster createBusStop(BusStopMaster busStopMaster);
	public BusStopMaster updateBusStop(BusStopMaster busStopMaster);

	
}
