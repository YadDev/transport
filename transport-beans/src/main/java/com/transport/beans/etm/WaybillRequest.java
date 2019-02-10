package com.transport.beans.etm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.databind.node.BigIntegerNode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WaybillRequest {

	private BigInteger waybillId;

	
	private BigDecimal actualKm;

	
	private int actualTrip;

	
	private String cashCollectClerk;

	

	private Date cashDepTime;


	private String dutyDate;


	private Date dutyGenTime;


	private String issueClerk;


	private int noOfDays;


	private int relBusTypeId;


	private BigInteger relDutyAllocationId;


	private String relEtimNo;

	
	private int relExtraReason;

	
	private int relVersionId;

	
	private int relWaybillStatusId;

	
	private BigDecimal scheduleKm;

	
	private int scheduleTrip;

	
	private String waybillCollectClerk;


	private Timestamp waybillCollectTime;


	private BigInteger waybillConductor;


	private String waybillDepot;


	private BigInteger waybillDriver;


	private String waybillNumber;

	
	private BigInteger waybillSupDriver;

	
	private String waybillType;

	
	private BigInteger waybillVehicle;

}
