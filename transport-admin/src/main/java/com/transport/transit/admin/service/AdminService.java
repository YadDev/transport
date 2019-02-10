package com.transport.transit.admin.service;

import java.util.List;

import com.transport.beans.admin.BusStopMasterRequest;
import com.transport.beans.admin.DepotRequest;
import com.transport.beans.admin.MenuMasterRequest;
import com.transport.beans.admin.RegionRequest;
import com.transport.beans.admin.VehicleRequest;


public interface AdminService {

	public List<MenuMasterRequest> loadMenuMaster(Integer roleID);
	public boolean createNewMenu(MenuMasterRequest createMenuRequest);
	public List<BusStopMasterRequest> loadAllBusStops();
	public BusStopMasterRequest getBusStopDetails(String StopCode);
	public boolean createBusStop(BusStopMasterRequest busStopMaster);
	public boolean updateBusStop(BusStopMasterRequest busStopMaster);
	public boolean removeBusStop(String busStopCode);
	//Depot Management
	public List<DepotRequest> getAllDepot();
	
	//Region Management
	public List<RegionRequest> getAllRegion();
	
	//Vehicle Master Management
	public List<VehicleRequest> getAllVehicle();
	
	
}
