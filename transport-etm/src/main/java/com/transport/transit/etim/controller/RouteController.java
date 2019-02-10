package com.transport.transit.etim.controller;

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

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.etm.RouteRequest;
import com.transport.beans.etm.RouteTypeRequest;
import com.transport.transit.etim.service.RouteService;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

@RestController
@RequestMapping("/etim")
public class RouteController {

	@Autowired
	private RouteService routeService;
	

	private BaseResponse response = null;

	
	@RequestMapping(value = "/getRouteType", method = RequestMethod.POST)
	public ResponseEntity<Object> getRouteType(HttpServletRequest request) {
		List<RouteTypeRequest> routeTypeList = new ArrayList<>();
		response = new BaseResponse();
		routeTypeList = routeService.getAllRouteType();
		if (routeTypeList != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(routeTypeList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	
	
	@RequestMapping(value = "/getAllRoutes", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllRoutes(HttpServletRequest request) {
		List<RouteRequest> routeList = new ArrayList<>();
		response = new BaseResponse();
//		if (validateUserHeader(loginService, request)) {
		routeList = routeService.getAllActiveRoute();
		if (routeList != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(routeList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/routeDetail", method = RequestMethod.POST)
	public ResponseEntity<Object> getBusStopDetails(@RequestBody Integer routeID, HttpServletRequest request) {
		RouteRequest routeDetail = new RouteRequest();
		response = new BaseResponse();
		System.out.println("Route Input Parameter " + routeID);
		routeDetail = routeService.getRouteDetail(routeID);
		if (routeDetail != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(routeDetail);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/createNewRoute", method = RequestMethod.POST)
	public ResponseEntity<Object> createBusStop(@RequestBody RouteRequest routeRequest) {
		System.out.println("New Route to Add " + routeRequest.toString());
		boolean resp = false;
		try {
			resp = routeService.createRoute(routeRequest);
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(resp);
		} catch (Exception e) {
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData(e.getMessage());
			e.printStackTrace();
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/updateRouteDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBusStop(@RequestBody RouteRequest routeRequest) {
		System.out.println("Route Detail to get updated " + routeRequest.toString());
		boolean resp = false;
		try {
			resp = routeService.updateRoute(routeRequest);
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(resp);
		} catch (Exception e) {
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData(e.getMessage());
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/removeRoute", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeBusStop(@RequestBody Integer routeID) {
		System.out.println("Route to detele from database  " + routeID);
		response = new BaseResponse();
		boolean resp = false;
		try {
			resp = routeService.removeRoute(routeID);
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(resp);
		} catch (Exception e) {
			response = new BaseResponse();
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData(e.getMessage());
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
}
