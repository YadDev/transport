package com.transport.transit.persistence.dao;

import java.util.List;

import com.transport.transit.persistence.entity.RouteEntity;
import com.transport.transit.persistence.entity.RouteStopEntity;

public interface RouteDAO {
	public String InsertRoute(RouteEntity route,List<RouteStopEntity> stopEntity);

}
