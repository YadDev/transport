package com.transport.beans.etm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class RouteTypeRequest {

	private String routeTypeId;

	private String routeTypeCode;

	private String routeTypeName;

}
