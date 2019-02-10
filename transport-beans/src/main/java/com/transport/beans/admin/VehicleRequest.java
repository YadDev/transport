package com.transport.beans.admin;

import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class VehicleRequest {

	private String vehicleId;

	private String chasisNumber;

	private String engineNumber;

	private Date manufacturingYear;

	private Date purchaseDate;

	private int relBusFormatId;

	private int relBusTypeId;

	private int relOwnerId;

	private BigInteger relVehicleDepot;

	private String vehicleModel;

	private String vehicleNumber;

	private String vehicleOwner;
	
}
