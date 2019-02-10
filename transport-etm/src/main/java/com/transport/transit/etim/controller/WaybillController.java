package com.transport.transit.etim.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.etm.WaybillRequest;
import com.transport.transit.etim.service.WaybillService;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;



@RestController
@RequestMapping("/etim")
public class WaybillController {

	@Autowired
	WaybillService wayBillService;
	
	private BaseResponse resp=null;
	
	@RequestMapping(value = "/getMasterData", method = RequestMethod.POST)
	public String getInsiderListForCompany() {
		return "Devendra Kumar Yadav"; 
	}
	
	@RequestMapping(value = "/getWaybill", method = RequestMethod.POST)
	public ResponseEntity<Object> getWaybill(@RequestBody WaybillRequest testRequest) {
		System.out.println("in getWayBill Method "+testRequest.toString());
		
		try {
			
			resp=new BaseResponse();
			resp.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			resp.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			sdf.format(testRequest.getDutyDate());
			Date dutyDate=sdf.parse(sdf.format(testRequest.getDutyDate()));
			System.out.println("System is Duty Done "+dutyDate);
			resp.setRespData(wayBillService.findByConductorAndDutyDate(testRequest.getWaybillConductor(),dutyDate));
			
		} catch (Exception e) {
			resp = new BaseResponse();
			resp.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			resp.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			resp.setRespData(e.getMessage());
		}
		return CommonUtils.getResponse(resp, MediaType.APPLICATION_JSON);
	}
	
	
	
	@RequestMapping(value = "/createWaybill", method = RequestMethod.POST)
	public ResponseEntity<Object> createWaybill(@RequestBody WaybillRequest wayBillRequest) {
		System.out.println("in createWayBill Method "+wayBillRequest.toString());
		
		try {
			
			resp=new BaseResponse();
			resp.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			resp.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			resp.setRespData(wayBillService.createWayBill(wayBillRequest));
			
		} catch (Exception e) {
			resp = new BaseResponse();
			resp.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			resp.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			resp.setRespData(e.getMessage());
		}
		return CommonUtils.getResponse(resp, MediaType.APPLICATION_JSON);
	}
	
}
