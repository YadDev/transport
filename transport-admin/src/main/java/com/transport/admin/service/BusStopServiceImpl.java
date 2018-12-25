package com.transport.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.admin.entity.BusStopMaster;
import com.transport.admin.persistence.BusMasterRepo;

@Service
public class BusStopServiceImpl implements BusStopService {

	@Autowired
	private BusMasterRepo busRepo;
	
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

}
