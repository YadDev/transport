package com.transport.transit.etim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.beans.etm.RouteRequest;
import com.transport.beans.etm.RouteStopRequest;
import com.transport.beans.etm.RouteTypeRequest;
import com.transport.transit.persistence.dao.RouteDAO;
import com.transport.transit.persistence.entity.RouteEntity;
import com.transport.transit.persistence.entity.RouteStopEntity;
import com.transport.transit.persistence.entity.RouteTypeEntity;
import com.transport.transit.persistence.repostiory.RouteRepository;
import com.transport.transit.persistence.repostiory.RouteStopRepository;
import com.transport.transit.persistence.repostiory.RouteTypeRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private RouteStopRepository routeStopRepository;
	
	@Autowired
	private RouteDAO routeDAO;
	
	@Autowired
	private RouteTypeRepository routeTypeRepository;
	
	
	@Override
	public List<RouteRequest> getAllActiveRoute() {
		List<RouteRequest> routeList=new ArrayList<>();	
		List<RouteEntity> routeEntity=new ArrayList<>();
		routeEntity=routeRepository.findAll();
				
		for(RouteEntity entity:routeEntity) {
			RouteRequest routeDetail=new RouteRequest();
			routeDetail.setRelRouteCode(entity.getRelRouteCode());
			routeDetail.setRouteName(entity.getRouteName());
			routeDetail.setRelRouteType(entity.getRelRouteType());
			routeDetail.setRouteFromStop(entity.getRouteFromStop());
			routeDetail.setRouteStatus(entity.getRouteStatus());
//			routeDetail.setRouteId(routeEntity.getRouteId());
			routeDetail.setRouteViaStop(entity.getRouteViaStop());
			routeDetail.setRouteToStop(entity.getRouteToStop());
			routeList.add(routeDetail);
		}
		return routeList;
	}

	@Override
	public RouteRequest getRouteDetail(Integer routeID) throws NullPointerException {
		
		RouteRequest routeDetail=new RouteRequest();
		RouteEntity routeEntity=new RouteEntity();
		routeEntity=routeRepository.findByRouteId(""+routeID);
		
		routeDetail.setRelRouteCode(routeEntity.getRelRouteCode());
		routeDetail.setRouteName(routeEntity.getRouteName());
		routeDetail.setRelRouteType(routeEntity.getRelRouteType());
		routeDetail.setRouteFromStop(routeEntity.getRouteFromStop());
		routeDetail.setRouteStatus(routeEntity.getRouteStatus());
		routeDetail.setRouteId(routeEntity.getRouteId());
		routeDetail.setRouteViaStop(routeEntity.getRouteViaStop());
		routeDetail.setRouteToStop(routeEntity.getRouteToStop());
		
		
		System.out.println("Route Detail "+routeDetail.toString());
		return routeDetail;
	}

	

	@Transactional
	@Override
	public boolean createRoute(RouteRequest routeRequest) throws NullPointerException, DataAccessException {
		RouteEntity routeEntity=new RouteEntity();
		List<RouteStopEntity> routStopListEntity=new ArrayList<>();
		List<RouteStopRequest> routStopList=new ArrayList<>();
		
		routStopList=routeRequest.getRouteStops();

		routeEntity.setRelOrgId(routeRequest.getRelOrgId());
		routeEntity.setRelRouteCode(routeRequest.getRelRouteCode());
		routeEntity.setRelRouteType(routeRequest.getRelRouteType());
		routeEntity.setRouteCreatedAt(routeRequest.getRouteCreatedAt());
		routeEntity.setRouteFromStop(routeRequest.getRouteFromStop());
		routeEntity.setRouteId(generateRouteNumber());
		routeEntity.setRouteName(routeRequest.getRouteName());
		routeEntity.setRouteToStop(routeRequest.getRouteToStop());
		routeEntity.setRouteStatus(routeRequest.getRouteStatus());
		routeEntity.setRouteCreatedBy(routeRequest.getRouteCreatedBy());
		routeEntity.setRouteKm(routeRequest.getRouteKm());
		routeEntity.setRouteOrgNo(routeRequest.getRouteOrgNo());
		routeEntity.setRouteStateFive(routeRequest.getRouteStateFive());
		routeEntity.setRouteStateFour(routeRequest.getRouteStateFour());
		routeEntity.setRouteStateThree(routeRequest.getRouteStateThree());
		routeEntity.setRouteStateTwo(routeRequest.getRouteStateTwo());
		routeEntity.setRouteStateOne(routeRequest.getRouteStateOne());
		routeEntity.setRouteUnder(routeRequest.getRouteUnder());
		routeEntity.setRouteUpDnFlag(routeRequest.getRouteUpDnFlag());
		routeEntity.setRouteViaStop(routeRequest.getRouteViaStop());
		routeEntity.setRouteUpdatedAt(routeRequest.getRouteUpdatedAt());
		routeEntity.setRouteUpdatedBy(routeRequest.getRouteUpdatedBy());
		routeEntity = routeRepository.save(routeEntity);	
	
		for (RouteStopRequest temp : routStopList) {

			RouteStopEntity routeStopEntity = new RouteStopEntity();
		
			routeStopEntity.setEnrouteLatitute(temp.getEnrouteLatitute());
			routeStopEntity.setEnrouteLongitute(temp.getEnrouteLongitute());
			routeStopEntity.setEnrouteStopCode(temp.getEnrouteStopCode());
			routeStopEntity.setEnrouteStopSeq(temp.getEnrouteStopSeq());
			routeStopEntity.setRelRoutestopId(temp.getRelRoutestopId());
			routeStopEntity.setKmFromFirst(temp.getKmFromFirst());
			routeStopEntity.setStageNo(temp.getStageNo());
			routeStopEntity.setSubstageNo(temp.getSubstageNo());
			routeStopEntity.setInterstateKm(temp.getInterstateKm());
			routeStopEntity.setIntrastateKm(temp.getIntrastateKm());
			routeStopEntity.setInterstateStop(temp.getInterstateStop());
			routeStopEntity.setReservationStop(temp.getReservationStop());
			routeStopEntity.setStopActiveStatus(temp.getStopActiveStatus());
			routeStopEntity.setEnrouteCreatedBy(temp.getEnrouteCreatedBy());
			routeStopEntity.setEnrouteUpdatedBy(temp.getEnrouteUpdatedBy());
			routeStopEntity.setMstRoute(routeEntity);
			routeStopEntity=routeStopRepository.save(routeStopEntity);
			
		
		}
		

//		String status=routeDAO.InsertRoute(routeEntity,routStopListEntity);
		
		System.out.println("Route Stops ");		

		routeEntity=routeRepository.save(routeEntity);
				
		System.out.println("Route Creation");		
//		routeStopRepository.saveAll(routStopListEntity); 
		return true;
	}

	@Override
	public boolean updateRoute(RouteRequest routeRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRoute(Integer routeID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RouteTypeRequest> getAllRouteType() {
		List<RouteTypeRequest> routeType=new ArrayList<>();
		List<RouteTypeEntity> routeTypeEntity=new ArrayList<>();
		routeTypeEntity=routeTypeRepository.findAll();
		for(RouteTypeEntity entity:routeTypeEntity) {
			RouteTypeRequest req=new RouteTypeRequest();
			req.setRouteTypeCode(entity.getRouteTypeCode());
			req.setRouteTypeId(entity.getRouteTypeId());
			req.setRouteTypeName(entity.getRouteTypeName());
			routeType.add(req);
		}
		return routeType;
	}

	public static Integer generateRouteNumber() {
		Random rand=new Random();
		Integer routeNumber=rand.nextInt();
		return routeNumber;
	}
}
