package com.transport.beans.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class BusStopMasterRequest {
	private String busStopCode;
	private String busStopName;
	private String busStopAdd;
	private String busStopState;
	private String busStopStatus;
	private String lattitude;
	private String longitude;
	
}
