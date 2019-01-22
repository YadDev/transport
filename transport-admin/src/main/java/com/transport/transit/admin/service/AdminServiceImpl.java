package com.transport.transit.admin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.beans.admin.CreateMenuRequest;
import com.transport.transit.persistence.entity.BusStopMaster;
import com.transport.transit.persistence.entity.MenuEntity;
import com.transport.transit.persistence.repostiory.BusMasterRepository;
import com.transport.transit.persistence.repostiory.MenuRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private BusMasterRepository busRepo;
	
	@Override
	public List<CreateMenuRequest> loadMenuMaster(Integer roleID) {
		List<CreateMenuRequest> menuList=new ArrayList<CreateMenuRequest>(); 
		List<MenuEntity> menuEntityList=menuRepository.findAll();
			for(MenuEntity menu:menuEntityList) {
				CreateMenuRequest temp=new CreateMenuRequest();
				temp.setPageID(menu.getMenuId());
				temp.setPageName(menu.getMenuName());
				temp.setPageLink(menu.getMenuLink());
				temp.setPageSeq(menu.getMenuSeq());
				temp.setPageShortCut(menu.getMenuShortcutKey());
				menuList.add(temp);
			}		
		return menuList;
	}
	
	@Override
	public boolean createNewMenu(CreateMenuRequest createMenu) throws DataAccessException{
		MenuEntity menuEntity=new MenuEntity();
		menuEntity.setMenuName(createMenu.getPageName());
		menuRepository.save(menuEntity);
		return true;
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
