package com.transport.transit.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.beans.admin.BusStopMasterRequest;
import com.transport.beans.admin.MenuMasterRequest;
import com.transport.transit.persistence.entity.BusStopEntity;
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
	public List<MenuMasterRequest> loadMenuMaster(Integer roleID) {
		List<MenuMasterRequest> menuList=new ArrayList<MenuMasterRequest>(); 
		List<MenuEntity> menuEntityList=menuRepository.findAll();
			for(MenuEntity menu:menuEntityList) {
				MenuMasterRequest temp=new MenuMasterRequest();
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
	public boolean createNewMenu(MenuMasterRequest createMenu) throws DataAccessException{
		MenuEntity menuEntity=new MenuEntity();
		menuEntity.setMenuName(createMenu.getPageName());
		menuRepository.save(menuEntity);
		return true;
	}

	
	@Override
	public List<BusStopMasterRequest> loadAllBusStops() {
		List<BusStopMasterRequest> busStopList=new ArrayList<>();
		List<BusStopEntity> busStopEntity=new ArrayList<>();	
		busStopEntity=busRepo.findAll();	
		return busStopList;
	}

	@Override
	public BusStopMasterRequest getBusStopDetails(String stopCode) {
		BusStopEntity busStopEntity=new BusStopEntity();
		BusStopMasterRequest busStopDetails=new BusStopMasterRequest();
		busStopEntity=busRepo.findByBusStopCode(stopCode);
		return busStopDetails;
	}


	@Override
	public boolean createBusStop(BusStopMasterRequest busStopMaster) {
		System.out.println("Reposne before Save in Impl "+busStopMaster);
		BusStopEntity busStop=new BusStopEntity();
		busStop= busRepo.save(busStop);;
		return true;
	}

	

	@Override
	public BusStopMasterRequest updateBusStop(BusStopMasterRequest busStopMaster) {
		BusStopEntity busStop=new BusStopEntity();
		busStop= busRepo.save(busStop);		
		return busStopMaster;
		
	}
}
