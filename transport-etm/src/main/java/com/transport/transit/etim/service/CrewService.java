package com.transport.transit.etim.service;

import java.util.List;

import com.transport.beans.etm.CrewMasterRequest;

public interface CrewService {
	public List<CrewMasterRequest> getAllCrewDetailByCrewID(String crewID,String orgID);

}
