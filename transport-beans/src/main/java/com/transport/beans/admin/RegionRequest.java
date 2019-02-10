package com.transport.beans.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class RegionRequest {
	
	private int regionId;

	
	private String regionCode;

	
	private String regionName;

	
	private int relOrganizationId;

}
