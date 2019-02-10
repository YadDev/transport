package com.transport.transit.etim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.etm.CrewMasterRequest;
import com.transport.transit.etim.service.CrewService;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

@RestController
@RequestMapping("/etim")
public class CrewController {
	
	@Autowired
	private CrewService crewService;
	
	private BaseResponse response=null;

	@RequestMapping(value = "/getCrewData", method = RequestMethod.GET)
	public ResponseEntity<Object> getRouteType(@RequestParam String crewID, @RequestParam String orgID,HttpServletRequest request) {
		List<CrewMasterRequest> crewList = new ArrayList<>();
		response = new BaseResponse();
		crewList = crewService.getAllCrewDetailByCrewID(crewID, orgID);
		if (!crewList.isEmpty()) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(crewList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	
}
