package com.transport.transit.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.beans.admin.BusStopMasterRequest;
import com.transport.beans.admin.DepotRequest;
import com.transport.beans.admin.MenuMasterRequest;
import com.transport.beans.admin.RegionRequest;
import com.transport.beans.admin.VehicleRequest;
import com.transport.transit.persistence.entity.BusStopEntity;
import com.transport.transit.persistence.entity.DepotEntity;
import com.transport.transit.persistence.entity.MenuEntity;
import com.transport.transit.persistence.entity.RegionEntity;
import com.transport.transit.persistence.entity.VehicleEntity;
import com.transport.transit.persistence.repostiory.BusMasterRepository;
import com.transport.transit.persistence.repostiory.DepotRepository;
import com.transport.transit.persistence.repostiory.MenuRepository;
import com.transport.transit.persistence.repostiory.RegionRepository;
import com.transport.transit.persistence.repostiory.VehicleRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private BusMasterRepository busRepo;
	
	@Autowired
	private DepotRepository depotRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public List<MenuMasterRequest> loadMenuMaster(Integer roleID) throws DataAccessException {
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
	public List<BusStopMasterRequest> loadAllBusStops() throws DataAccessException {
		List<BusStopMasterRequest> busStopList=new ArrayList<>();
		List<BusStopEntity> busStopEntity=new ArrayList<>();	
		busStopEntity=busRepo.findAll();	
		for(BusStopEntity entity:busStopEntity) {
			BusStopMasterRequest busStop=new BusStopMasterRequest();
			busStop.setBusStopCode(entity.getBusStopCode());
			busStop.setBusStopName(entity.getBusStopName());
			busStop.setBusStopAdd(entity.getBusStopAdd());
			busStop.setBusStopState(entity.getBusStopStateCode());
			busStop.setBusStopStatus(entity.getBusStopStatus());
			busStop.setLattitude(entity.getLattitude());
			busStop.setLongitude(entity.getLongitude());
			busStopList.add(busStop);
		}
		return busStopList;
	}

	@Override
	public BusStopMasterRequest getBusStopDetails(String stopCode) throws DataAccessException,NullPointerException {
		BusStopEntity busStopEntity=new BusStopEntity();
		BusStopMasterRequest busStopDetails=new BusStopMasterRequest();
		busStopEntity=busRepo.findByBusStopCode(stopCode);
		
		busStopDetails.setBusStopCode(busStopEntity.getBusStopCode());
		busStopDetails.setBusStopName(busStopEntity.getBusStopName());
		busStopDetails.setBusStopAdd(busStopEntity.getBusStopAdd());
		busStopDetails.setBusStopState(busStopEntity.getBusStopStateCode());
		busStopDetails.setBusStopStatus(busStopEntity.getBusStopStatus());
		busStopDetails.setLattitude(busStopEntity.getLattitude());
		busStopDetails.setLongitude(busStopEntity.getLongitude());
		
		return busStopDetails;
	}


	@Override
	public boolean createBusStop(BusStopMasterRequest busStopMaster) throws DataAccessException, NullPointerException{
		System.out.println("Reposne before Save in Impl "+busStopMaster);
		BusStopEntity busStop=new BusStopEntity();
		busStop.setBusStopCode(busStopMaster.getBusStopCode());
		busStop.setBusStopName(busStopMaster.getBusStopName());
		busStop.setBusStopAdd(busStopMaster.getBusStopAdd());
		busStop.setBusStopStateCode(busStopMaster.getBusStopState());
		busStop.setBusStopStatus(busStopMaster.getBusStopStatus());
		busStop.setLattitude(busStopMaster.getLattitude());
		busStop.setLongitude(busStopMaster.getLongitude());
			
		busRepo.save(busStop);;
		return true;
	}

	

	@Override
	public boolean updateBusStop(BusStopMasterRequest busStopMaster) throws NullPointerException,DataAccessException{
		BusStopEntity busStopEntity=new BusStopEntity();
		
		busStopEntity.setBusStopCode(busStopMaster.getBusStopCode());
		busStopEntity.setBusStopName(busStopMaster.getBusStopName());
		busStopEntity.setBusStopAdd(busStopMaster.getBusStopAdd());
		busStopEntity.setBusStopStateCode(busStopMaster.getBusStopState());
		busStopEntity.setBusStopStatus(busStopMaster.getBusStopStatus());
		busStopEntity.setLattitude(busStopMaster.getLattitude());
		busStopEntity.setLongitude(busStopMaster.getLongitude());
		busRepo.save(busStopEntity);		
		return true;
		
	}

	@Override
	public boolean removeBusStop(String busStopCode) throws DataAccessException,NullPointerException {
		busRepo.deleteByBusStopCode(busStopCode);
		return true;
	}

	@Override
	public List<DepotRequest> getAllDepot() throws NullPointerException, DataAccessException {
		List<DepotEntity> depotEntity=new ArrayList<>();
		List<DepotRequest>depotList=new ArrayList<>();
		depotEntity=depotRepository.findAll();
		for(DepotEntity entity:depotEntity) {
			DepotRequest depot=new DepotRequest();
			depot.setDepotId(entity.getDepotId());
			depot.setDepotCode(entity.getDepotCode());
			depot.setDepotCreatedAt(entity.getDepotCreatedAt());
			depot.setDepotCreatedBy(entity.getDepotCreatedBy());
			depot.setDepotName(entity.getDepotName());
			depot.setRelDivisionId(entity.getRelDivisionId());			
			depotList.add(depot);
		}
		return depotList;
	}

	@Override
	public List<VehicleRequest> getAllVehicle() throws NullPointerException,DataAccessException {
		List<VehicleEntity> vehicleEntity=new ArrayList<>();
		List<VehicleRequest> vehicleList=new ArrayList<>();
		vehicleEntity=vehicleRepository.findAll();
		for(VehicleEntity entity:vehicleEntity) {
			
			VehicleRequest vehicle=new VehicleRequest();
			vehicle.setChasisNumber(entity.getChasisNumber());
			vehicle.setEngineNumber(entity.getEngineNumber());
			vehicle.setManufacturingYear(entity.getManufacturingYear());
			vehicle.setPurchaseDate(entity.getPurchaseDate());
			vehicle.setRelBusFormatId(entity.getRelBusFormatId());
			vehicle.setRelBusTypeId(entity.getRelBusTypeId());
			vehicle.setRelOwnerId(entity.getRelOwnerId());
			vehicle.setRelVehicleDepot(entity.getRelVehicleDepot());
			vehicle.setVehicleId(entity.getVehicleId());
			vehicle.setVehicleModel(entity.getVehicleModel());
			vehicle.setVehicleNumber(entity.getVehicleNumber());
			vehicle.setVehicleOwner(entity.getVehicleOwner());
			vehicleList.add(vehicle);
		}
		
		return vehicleList;
	}

	@Override
	public List<RegionRequest> getAllRegion() {
		List<RegionRequest> regionList=new ArrayList<>();
		List<RegionEntity> regionEntity=new ArrayList<>();
		regionEntity=regionRepository.findAll();
		for(RegionEntity entity:regionEntity) {
			RegionRequest temp=new RegionRequest();
			
			temp.setRegionCode(entity.getRegionCode());
			temp.setRegionName(entity.getRegionName());
			temp.setRegionId(entity.getRegionId());
			temp.setRelOrganizationId(entity.getRelOrganizationId());
			
			regionList.add(temp);
		}
		
		return regionList;
	}
}
