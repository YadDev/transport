package com.transport.transit.persistence.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transport.transit.persistence.entity.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity,Long> {
	public RouteEntity findByRouteId(String id);
	
	final static String FETCH_LAST_INSERTED_ROUTE_ID="select max(route_id) from mst_routes;";
	@Query(value = FETCH_LAST_INSERTED_ROUTE_ID, nativeQuery = true)
	public int fetchLastRouteID();

}
