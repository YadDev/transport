package com.transport.beans.etm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class RouteRequest {
	
	private int routeId;

	
	private int relOrgId;


	private String relRouteCode;


	private int relRouteType;



	private Date routeCreatedAt;


	private int routeCreatedBy;


	private String routeFromStop;


	private BigDecimal routeKm;


	private String routeName;


	private String routeOrgNo;


	private int routeStateFive;


	private int routeStateFour;

	
	private int routeStateOne;

	
	private int routeStateThree;

	
	private int routeStateTwo;

	
	private String routeStatus;

	
	private String routeToStop;

	
	private String routeUnder;

	
	private String routeUpDnFlag;

	
	private Timestamp routeUpdatedAt;

	
	private int routeUpdatedBy;

	
	private String routeViaStop;

	private List<RouteStopRequest> routeStops;

}
