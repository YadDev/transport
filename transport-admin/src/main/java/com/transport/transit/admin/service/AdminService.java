package com.transport.transit.admin.service;

import java.util.List;

import com.transport.beans.admin.BusStopMasterRequest;
import com.transport.beans.admin.MenuMasterRequest;


public interface AdminService {

	public List<MenuMasterRequest> loadMenuMaster(Integer roleID);
	public boolean createNewMenu(MenuMasterRequest createMenuRequest);
	public List<BusStopMasterRequest> loadAllBusStops();
	public BusStopMasterRequest getBusStopDetails(String StopCode);
	public boolean createBusStop(BusStopMasterRequest busStopMaster);
	public BusStopMasterRequest updateBusStop(BusStopMasterRequest busStopMaster);

	
}
