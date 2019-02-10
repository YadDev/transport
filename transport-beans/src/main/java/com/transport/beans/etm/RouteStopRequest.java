package com.transport.beans.etm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

public class RouteStopRequest{

	private String enrouteStopId;
	
	private Date enrouteCreatedAt;

	private int enrouteCreatedBy;

	private double enrouteLatitute;

	
	private double enrouteLongitute;

	
	private String enrouteStopCode;

	
	private int enrouteStopSeq;

	
	private Timestamp enrouteUpdatedAt;

	
	private int enrouteUpdatedBy;

	
	private BigDecimal interstateKm;

	
	private String interstateStop;

	
	private BigDecimal intrastateKm;

	
	private BigDecimal kmFromFirst;

	
	private BigInteger relRouteId;

	
	private BigInteger relRoutestopId;

	
	private String reservationStop;

	
	private String stageNo;

	
	private String stopActiveStatus;

	
	private String substageNo;

	
}