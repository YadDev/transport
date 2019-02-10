package com.transport.transit.etim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.transport.beans.etm.CrewMasterRequest;
import com.transport.transit.persistence.entity.CrewEntity;
import com.transport.transit.persistence.repostiory.CrewRepository;

@Service
public class CrewServiceImpl implements CrewService {

	@Autowired
	private CrewRepository crewRepository;
	@Override
	public List<CrewMasterRequest> getAllCrewDetailByCrewID(String crewID, String orgID) throws NullPointerException,DataAccessException {
		List<CrewEntity> crewEntity=new ArrayList<>();
		List<CrewMasterRequest> crewList=new ArrayList<>();
		crewEntity=crewRepository.findByRelCrewTypeAndOrgUniqueId(Integer.valueOf(crewID), orgID);
		for(CrewEntity entity:crewEntity) {
			CrewMasterRequest crew=new CrewMasterRequest();
			crew.setCrewBirthDate(entity.getCrewBirthDate());
			crew.setCrewCardId(entity.getCrewCardId());
			crew.setCrewCreatedAt(entity.getCrewCreatedAt());
			crew.setCrewCreatedBy(entity.getCrewCreatedBy());
			crewList.add(crew);
		}
		return crewList;
	}

}
