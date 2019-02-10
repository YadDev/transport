package com.transport.transit.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.admin.BaseResponse;
import com.transport.beans.admin.BusStopMasterRequest;
import com.transport.beans.admin.DepotRequest;
import com.transport.beans.admin.MenuMasterRequest;
import com.transport.beans.admin.RegionRequest;
import com.transport.beans.admin.UserMasterRequest;
import com.transport.beans.admin.VehicleRequest;
import com.transport.transit.admin.service.AdminService;
import com.transport.transit.admin.service.LoginServiceImpl;
import com.transport.util.commons.CommonUtils;
import com.transport.util.commons.StringsUtils;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private AdminService adminService;

	BaseResponse response = null;

	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	public ResponseEntity<Object> getMenu(@RequestBody String roleID, HttpServletRequest request) {
		List<MenuMasterRequest> lists = new ArrayList<>();
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
	public ResponseEntity<Object> createMenu(@RequestBody MenuMasterRequest createMenuRequest) {
		System.out.println("Menu to Add " + createMenuRequest.toString());
		response = new BaseResponse();
		boolean resp = false;
		try {
			resp = adminService.createNewMenu(createMenuRequest);
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(resp);
		} catch (Exception e) {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespMessage(e.getMessage());
		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

//Bus Stop Related RequestMapping

	@RequestMapping(value = "/getBusStops", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllBusStops(HttpServletRequest request) {
		List<BusStopMasterRequest> busStopsList = new ArrayList<>();
		response = new BaseResponse();
//		if (validateUserHeader(loginService, request)) {
		busStopsList = adminService.loadAllBusStops();
		if (busStopsList != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(busStopsList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}
//		} else {
//			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
//			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/busStopDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> getBusStopDetails(@RequestBody String busStopCode, HttpServletRequest request) {
		BusStopMasterRequest busStopDetails = new BusStopMasterRequest();
		response = new BaseResponse();
		System.out.println("Input Parameter " + busStopCode);
		busStopDetails = adminService.getBusStopDetails("THN");
		if (busStopDetails != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(busStopDetails);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}

		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/createBusStop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createBusStop(@RequestBody BusStopMasterRequest busStopMaster) {
		System.out.println("New BusStop to Add " + busStopMaster.toString());
		boolean resp = false;
		try {
			resp = adminService.createBusStop(busStopMaster);
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

	@RequestMapping(value = "/updateBusStop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBusStop(@RequestBody BusStopMasterRequest busStopMaster) {
		System.out.println("New BusStop to Add " + busStopMaster.toString());
		boolean resp = false;
		try {
			resp = adminService.updateBusStop(busStopMaster);
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

	@RequestMapping(value = "/removeBusStop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeBusStop(@RequestBody String busStopCode) {
		System.out.println("New BusStop to Add " + busStopCode);
		response = new BaseResponse();
		boolean resp = false;
		try {
			resp = adminService.removeBusStop(busStopCode);
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

//Depot Management

	@RequestMapping(value = "/getDepotList", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllDepot(HttpServletRequest request) {
		List<DepotRequest> depotList = new ArrayList<>();
		response = new BaseResponse();
//		if (validateUserHeader(loginService, request)) {
		depotList = adminService.getAllDepot();
		if (depotList != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(depotList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}
//		} else {
//			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
//			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/getRegionList", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllRegion(HttpServletRequest request) {
		List<RegionRequest> regionList = new ArrayList<>();
		response = new BaseResponse();
//		if (validateUserHeader(loginService, request)) {
		regionList = adminService.getAllRegion();
		if (regionList != null) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(regionList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}
//		} else {
//			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
//			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
//			response.setRespData("UnAuthorised Access!");
//		}
		return CommonUtils.getResponse(response, MediaType.APPLICATION_JSON);
	}

	@RequestMapping(value = "/getAllVehicle", method = RequestMethod.POST)
	public ResponseEntity<Object> getAllVehicle(HttpServletRequest request) {
		List<VehicleRequest> vehicleList = new ArrayList<>();
		response = new BaseResponse();
//		if (validateUserHeader(loginService, request)) {
		vehicleList = adminService.getAllVehicle();
		if (!vehicleList.isEmpty()) {
			response.setRespCode(StringsUtils.Response.SUCCESS_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.SUCCESS_RESP_MSG);
			response.setRespData(vehicleList);
		} else {
			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
			response.setRespData("No Data Available!");
		}
//		} else {
//			response.setRespCode(StringsUtils.Response.FAILURE_RESP_CODE);
//			response.setRespMessage(StringsUtils.Response.FAILURE_RESP_MSG);
//			response.setRespData("UnAuthorised Access!");
//		}
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
					UserMasterRequest user = userService.findByUserName(userName);

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
