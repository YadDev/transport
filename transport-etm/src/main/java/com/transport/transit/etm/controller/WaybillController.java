package com.transport.transit.etm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.etm.WaybillBeans;
import com.transport.transit.etm.service.WaybillService;
import com.transport.util.commons.CommonUtils;


@RestController
@RequestMapping("/etm")
public class WaybillController {

	@Autowired
	WaybillService testService;
	
	
	@RequestMapping(value = "/getMasterData", method = RequestMethod.POST)
	public String getInsiderListForCompany() {
		return "Devendra Kumar Yadav"; 
	}
	
	@RequestMapping(value = "/getWaybill", method = RequestMethod.POST)
	public ResponseEntity<Object> getWaybill(@RequestBody WaybillBeans testRequest) {
		System.out.println("in getWayBill Method "+testRequest.toString());
		return CommonUtils.getResponse(testService.findByConductorAndDutyDate(testRequest.getWaybill_conductor(),testRequest.getDuty_date()), MediaType.APPLICATION_JSON);
	}
	
}
