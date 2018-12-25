package com.transport.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.admin.entity.BusStopMaster;
import com.transport.admin.entity.MenuMaster;
import com.transport.admin.service.BusStopService;
import com.transport.admin.service.HomeService;
import com.transport.admin.service.LoginServiceImpl;
import com.transport.beans.admin.BaseResponse;
import com.transport.util.commons.CommonUtils;

@RestController
@RequestMapping("/secure")
public class HomeController {
	
	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private HomeService main;
	
	BaseResponse response=null;
	
	@Autowired
	private BusStopService busStopService;
	
	@RequestMapping(value="/menus",method = RequestMethod.POST)
	public ResponseEntity<Object> getMenu(HttpServletRequest request){
		List<MenuMaster> lists=new ArrayList<>();
		response=new BaseResponse();
		if(CommonUtils.validateUserHeader(loginService, request)) {
			lists=main.loadMenuMaster(1);
			response.setRespCode("00");
			response.setRespData(lists);
		}
		else {
			response.setRespCode("01");
			response.setRespData("UnAuthorised Access!");
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	@RequestMapping(value="/busStops",method = RequestMethod.POST)
	public ResponseEntity<Object> getAllBusStops(HttpServletRequest request){
		List<BusStopMaster> busStopsList=new ArrayList<>();		
		response=new BaseResponse();
		if(CommonUtils.validateUserHeader(loginService, request)) {
			busStopsList=busStopService.loadAllBusStops();
			if(busStopsList!=null)
			{
				response.setRespCode("00");
				response.setRespData(busStopsList);
			}
			else {
				response.setRespCode("01");
				response.setRespData("No Data Available!");
			}			
		}
		else {
			response.setRespCode("01");
			response.setRespData("UnAuthorised Access!");
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	@RequestMapping(value="/busStopDetails",method = RequestMethod.POST)
	public ResponseEntity<Object> getBusStopDetails(@RequestBody BusStopMaster stopDetails,HttpServletRequest request){
		BusStopMaster busStopDetails=new BusStopMaster();		
		response=new BaseResponse();
		System.out.println("Input Parameter "+stopDetails);
//		if(CommonUtils.validateUserHeader(loginService, request)) {
			busStopDetails=busStopService.getBusStopDetails("MUM");
			if(busStopDetails!=null)
			{
				response.setRespCode("00");
				response.setRespData(busStopDetails);
			}
			else {
				response.setRespCode("01");
				response.setRespData("No Data Available!");
			}			
//		}
//		else {
//			response.setRespCode("01");
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
}
