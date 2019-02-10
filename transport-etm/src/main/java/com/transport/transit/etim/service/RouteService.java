
package com.transport.transit.etim.service;

import java.util.List;

import com.transport.beans.etm.RouteRequest;
import com.transport.beans.etm.RouteTypeRequest;

public interface RouteService {
	public List<RouteRequest> getAllActiveRoute();
	public RouteRequest getRouteDetail(Integer routeID);
	public boolean createRoute(RouteRequest routeRequest);
	public boolean updateRoute(RouteRequest routeRequest);
	public boolean removeRoute(Integer routeID);
	public List<RouteTypeRequest> getAllRouteType();
//	public String createRoute(String name,String code,String status,String from,String toStop,String via);

}
