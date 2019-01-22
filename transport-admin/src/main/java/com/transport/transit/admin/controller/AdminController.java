package com.transport.transit.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.admin.CreateMenuRequest;
import com.transport.transit.admin.service.AdminService;
import com.transport.transit.admin.service.LoginServiceImpl;
import com.transport.transit.persistence.entity.BusStopMaster;
import com.transport.transit.persistence.entity.MenuEntity;
import com.transport.transit.persistence.entity.UserCredential;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

@RestController
@RequestMapping("/secure")
public class AdminController {

	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private AdminService adminService;

	BaseResponse response = null;

	
	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	public ResponseEntity<Object> getMenu(@RequestBody String roleID,HttpServletRequest request) {
		List<CreateMenuRequest> lists = new ArrayList<>();
		response = new BaseResponse();
//		if(validateUserHeader(loginService, request)) {
		lists = adminService.loadMenuMaster(1);
//		response.setRespCode(1);
//		response.setRespData(lists);
//		}
//		else {
//			response.setRespCode("01");
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(lists, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/createMenu", method = RequestMethod.POST)
	public ResponseEntity<Object> createMenu(@RequestBody CreateMenuRequest createMenuRequest) {
		System.out.println("Menu to Add "+createMenuRequest.toString());
		response = new BaseResponse();
		try {  
			response.setRespCode(1);
			response.setRespMessage("Data Saved Successfully.");
			response.setRespData(adminService.createNewMenu(createMenuRequest));
		}
		catch (DataAccessException e) {
			response.setRespMessage(e.getMessage());
		}		
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

//Bus Stop Related RequestMapping
	
	@RequestMapping(value = "/busStops", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllBusStops(HttpServletRequest request) {
		List<BusStopMaster> busStopsList = new ArrayList<>();
		response = new BaseResponse();
		if (validateUserHeader(loginService, request)) {
			busStopsList = adminService.loadAllBusStops();
			if (busStopsList != null) {
				response.setRespCode(1);
				response.setRespData(busStopsList);
			} else {
				response.setRespCode(0);
				response.setRespData("No Data Available!");
			}
		} else {
			response.setRespCode(0);
			response.setRespData("UnAuthorised Access!");
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	// @Valid

	/*
	 * if (bindingResult.hasErrors()) {
	 * response.setMessage(bindingResultUtils.stringifyError(bindingResult.
	 * getAllErrors())); }
	 */

	@RequestMapping(value = "/busStopDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> getBusStopDetails(@RequestBody BusStopMaster stopDetails,
			HttpServletRequest request) {
		BusStopMaster busStopDetails = new BusStopMaster();
		response = new BaseResponse();
		System.out.println("Input Parameter " + stopDetails);
//		if(CommonUtils.validateUserHeader(loginService, request)) {
		busStopDetails = adminService.getBusStopDetails("MUM");
		if (busStopDetails != null) {
			response.setRespCode(1);
			response.setRespData(busStopDetails);
		} else {
			response.setRespCode(0);
			response.setRespData("No Data Available!");
		}
//		}
//		else {
//			response.setRespCode("01");
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	
	@RequestMapping(value = "/createBusStop", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createBusStop(@RequestBody BusStopMaster busStopMaster) {
		System.out.println("New BusStop to Add "+busStopMaster.toString());		
		BusStopMaster temp=adminService.createBusStop(busStopMaster);
		response = new BaseResponse();
		response.setRespCode(0);
		response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
		response.setRespData(temp);
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/updateBusStop", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBusStop(@RequestBody BusStopMaster busStopMaster) {
		System.out.println("New BusStop to Add "+busStopMaster.toString());
		busStopMaster=adminService.updateBusStop(busStopMaster);
		response = new BaseResponse();
		response.setRespCode(0);
		response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
		response.setRespData(busStopMaster);
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}
	
	@RequestMapping(value = "/removeBusStop", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeBusStop(@RequestBody String busStopCode) {
		System.out.println("New BusStop to Add "+busStopCode);		
		response = new BaseResponse();
		response.setRespCode(0);
		response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
		response.setRespData(busStopCode);
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}


	
	public static boolean validateUserHeader(LoginServiceImpl userService, HttpServletRequest request) {
		boolean response = false;
		try {
			HttpSession session = request.getSession();
			ServletContext sc = session.getServletContext();
			if (sc.getAttribute("hMap") != null) {
				@SuppressWarnings("unchecked")
				HashMap<String, String> application = (HashMap<String, String>) sc.getAttribute("hMap");
				if (request.getParameter("SessionUserName") != null) {
					String userName = request.getParameter("SessionUserName").toString();
					String sessionID = application.get(userName);
					UserCredential user = userService.findByUserName(userName);

					if (session.getAttribute("" + user.getUserId()) != null
							&& sessionID.equals(session.getAttribute("" + user.getUserId()).toString())) {
						response = true;
					} else {

						response = true;
					}
				} else {
					response = false;
				}

			}
		} catch (Exception e) {
			response = false;
		}
		return response;
	}

}
