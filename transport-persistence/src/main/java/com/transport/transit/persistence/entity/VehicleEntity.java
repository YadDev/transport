package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the mst_vehicle_master database table.
 * 
 */
@Entity
@Table(name="mst_vehicle_master")
@NamedQuery(name="VehicleEntity.findAll", query="SELECT v FROM VehicleEntity v")
public class VehicleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vehicle_id")
	private String vehicleId;

	@Column(name="chasis_number")
	private String chasisNumber;

	@Column(name="engine_number")
	private String engineNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="manufacturing_year")
	private Date manufacturingYear;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private Date purchaseDate;

	@Column(name="rel_bus_format_id")
	private int relBusFormatId;

	@Column(name="rel_bus_type_id")
	private int relBusTypeId;

	@Column(name="rel_owner_id")
	private int relOwnerId;

	@Column(name="rel_vehicle_depot")
	private BigInteger relVehicleDepot;

	@Column(name="vehicle_model")
	private String vehicleModel;

	@Column(name="vehicle_number")
	private String vehicleNumber;

	@Column(name="vehicle_owner")
	private String vehicleOwner;

	public VehicleEntity() {
	}

	public String getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getChasisNumber() {
		return this.chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getEngineNumber() {
		return this.engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public Date getManufacturingYear() {
		return this.manufacturingYear;
	}

	public void setManufacturingYear(Date manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getRelBusFormatId() {
		return this.relBusFormatId;
	}

	public void setRelBusFormatId(int relBusFormatId) {
		this.relBusFormatId = relBusFormatId;
	}

	public int getRelBusTypeId() {
		return this.relBusTypeId;
	}

	public void setRelBusTypeId(int relBusTypeId) {
		this.relBusTypeId = relBusTypeId;
	}

	public int getRelOwnerId() {
		return this.relOwnerId;
	}

	public void setRelOwnerId(int relOwnerId) {
		this.relOwnerId = relOwnerId;
	}

	public BigInteger getRelVehicleDepot() {
		return this.relVehicleDepot;
	}

	public void setRelVehicleDepot(BigInteger relVehicleDepot) {
		this.relVehicleDepot = relVehicleDepot;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleNumber() {
		return this.vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleOwner() {
		return this.vehicleOwner;
	}

	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

}