package com.transport.transit.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.transport.transit.persistence.entity.RouteEntity;
import com.transport.transit.persistence.entity.RouteStopEntity;
import com.transport.transit.persistence.repostiory.RouteRepository;

@Component 
public class RouteDAOImpl implements RouteDAO {
	
	@Autowired 
	private JdbcTemplate dataSource;
	
	@Autowired
	private RouteRepository routeRepository;

	@Override
	public String InsertRoute(RouteEntity routeEntity,List<RouteStopEntity> routStopEntity) {
		String errorCode=null;
		Connection con=null;
		try {
			con=dataSource.getDataSource().getConnection();
			String	sql =  " insert into  mst_routes("+
						   "rel_org_id,"+
						   " rel_route_code,"+
						   "rel_route_type,"+
						   " route_from_stop,"+
						   " route_name,"+						   
						   " route_to_stop,"+
						   "route_status,"+
						   " route_km,"+
						   "route_org_no,"+
						   " route_state_one,"+						   
						   " route_state_two,"+
						   " route_state_three,"+
						   "route_state_four,"+
						   "route_state_five,"+
						   " route_under,"+
						   "route_up_dn_flag,"+
						   " route_via_stop,"+
						   "route_updated_by,"+
//						   "route_updated_at,"+
						   "route_created_by)"+						   
						
						   " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,routeEntity.getRelOrgId());
			stmt.setString(2,routeEntity.getRelRouteCode());
			stmt.setInt(3,routeEntity.getRelRouteType());
//			stmt.setDate(1,routeEntity.getRouteCreatedAt());
			stmt.setString(4,routeEntity.getRouteFromStop());
//			stmt.setInt(1,routeEntity.getRouteId());
			stmt.setString(5,routeEntity.getRouteName());
			stmt.setString(6,routeEntity.getRouteToStop());
			stmt.setString(7,routeEntity.getRouteStatus());
			stmt.setBigDecimal(8,routeEntity.getRouteKm());
			stmt.setString(9,routeEntity.getRouteOrgNo());
			stmt.setInt(10,routeEntity.getRouteStateFive());
			stmt.setInt(11,routeEntity.getRouteStateFour());
			stmt.setInt(12,routeEntity.getRouteStateThree());
			stmt.setInt(13,routeEntity.getRouteStateTwo());
			stmt.setInt(14,routeEntity.getRouteStateOne());
			stmt.setString(15,routeEntity.getRouteUnder());
			stmt.setString(16,routeEntity.getRouteUpDnFlag());
			stmt.setString(17,routeEntity.getRouteViaStop());
//			stmt.setTimestamp(18,routeEntity.getRouteUpdatedAt());
			stmt.setInt(18,routeEntity.getRouteUpdatedBy());
			stmt.setInt(19,routeEntity.getRouteCreatedBy());
//			stmt.setString(21,routeEntity.getRouteOrgNo());
			
			System.out.println("Query Before Insertion ");
			int i= stmt.executeUpdate();
			if(i>0){
				errorCode="01";
				int routeID=routeRepository.fetchLastRouteID();
				for(RouteStopEntity entity:routStopEntity) {
					errorCode=createRouteStops(entity,routeID);
				}			
				
			}else{
				errorCode="00";
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="00";
		}
			return errorCode;
	}

	public String createRouteStops(RouteStopEntity routeStopsEntity,int routeID) {
		String errorCode=null;
		Connection con=null;
		try {
			con=dataSource.getDataSource().getConnection();
			String	sql =  " insert into  mst_route_stops("+
						   "rel_route_id,"+
						   " enroute_stop_seq,"+
						   "rel_routestop_id,"+
						   " enroute_stop_code,"+
						   " km_from_first,"+						   
						   " stage_no,"+
						   "substage_no,"+
						   " interstate_km,"+
						   "intrastate_km,"+
						   " interstate_stop,"+						   
						   " reservation_stop,"+
						   " stop_active_status,"+
						   "enroute_latitute,"+
						   "enroute_longitute,"+
						   " enroute_created_by,"+
						   "enroute_updated_by)"+						   
						
						   " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,routeID);
			stmt.setInt(2,routeStopsEntity.getEnrouteStopSeq());
			stmt.setString(3,routeStopsEntity.getEnrouteStopId());
//			stmt.setDate(1,routeEntity.getRouteCreatedAt());
			stmt.setString(4,routeStopsEntity.getEnrouteStopCode());
//			stmt.setInt(1,routeEntity.getRouteId());
			stmt.setBigDecimal(5,routeStopsEntity.getKmFromFirst());
			stmt.setString(6,routeStopsEntity.getStageNo());
			stmt.setString(7,routeStopsEntity.getSubstageNo());
			stmt.setBigDecimal(8,routeStopsEntity.getInterstateKm());
			stmt.setBigDecimal(9,routeStopsEntity.getIntrastateKm());
			stmt.setString(10,routeStopsEntity.getInterstateStop());
			stmt.setString(11,routeStopsEntity.getReservationStop());
			stmt.setString(12,routeStopsEntity.getStopActiveStatus());
			stmt.setDouble(13,routeStopsEntity.getEnrouteLatitute());
			stmt.setDouble(14,routeStopsEntity.getEnrouteLongitute());
			stmt.setInt(15,routeStopsEntity.getEnrouteCreatedBy());
			stmt.setInt(16,routeStopsEntity.getEnrouteUpdatedBy());
			
			System.out.println("Query Before Stop Creation "+stmt.toString());
			int i= stmt.executeUpdate();
			if(i>0){
				errorCode="01";
		
			}else{
				errorCode="00";
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="00";
		}
			return errorCode;
		
	}
	
}
