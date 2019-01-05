package com.transport.transit.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.transit.persistence.entity.BusStopMaster;
import com.transport.transit.persistence.entity.MenuMaster;
import com.transport.transit.persistence.repostiory.BusMasterRepo;
import com.transport.transit.persistence.repostiory.MenuRepo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MenuRepo menus;
	
	@Autowired
	private BusMasterRepo busRepo;
	
	@Override
	public List<MenuMaster> loadMenuMaster(Integer roleID) {
		List<MenuMaster> menuList=new ArrayList<>();	
		menuList=menus.findAll();		
		return menuList;
	}
	
	@Override
	public MenuMaster createNewMenu(MenuMaster menu) {
		MenuMaster newMenu=new MenuMaster();
		try {
			newMenu=menus.save(menu);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return newMenu;
	}

	
	@Override
	public List<BusStopMaster> loadAllBusStops() {
		List<BusStopMaster> busStopList=new ArrayList<>();	
		busStopList=busRepo.findAll();	
		return busStopList;
	}

	@Override
	public BusStopMaster getBusStopDetails(String stopCode) {
		BusStopMaster busStopDetails=new BusStopMaster();
		busStopDetails=busRepo.findByBusStopCode(stopCode);
		return busStopDetails;
	}


	@Override
	public BusStopMaster createBusStop(BusStopMaster busStopMaster) {
		System.out.println("Reposne before Save in Impl "+busStopMaster);
		BusStopMaster busStop=new BusStopMaster();
		busStop= busRepo.save(busStopMaster);;
		return busStop;
	}


	@Override
	public BusStopMaster updateBusStop(BusStopMaster busStopMaster) {
		BusStopMaster busStop=new BusStopMaster();
		busStop= busRepo.save(busStopMaster);
		return busStop;
		
	}
}
