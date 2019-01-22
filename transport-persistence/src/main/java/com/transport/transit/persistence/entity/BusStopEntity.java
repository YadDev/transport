package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_bus_stop database table.
 * 
 */
@Entity
@Table(name="mst_bus_stop")
@NamedQuery(name="BusStopEntity.findAll", query="SELECT b FROM BusStopEntity b")
public class BusStopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="bus_stop_add")
	private String busStopAdd;

	@Column(name="bus_stop_code")
	private String busStopCode;

	@Column(name="bus_stop_name")
	private String busStopName;

	@Column(name="bus_stop_state_code")
	private String busStopStateCode;

	@Column(name="bus_stop_status")
	private String busStopStatus;

	private String lattitude;

	private String longitude;

	public BusStopEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusStopAdd() {
		return this.busStopAdd;
	}

	public void setBusStopAdd(String busStopAdd) {
		this.busStopAdd = busStopAdd;
	}

	public String getBusStopCode() {
		return this.busStopCode;
	}

	public void setBusStopCode(String busStopCode) {
		this.busStopCode = busStopCode;
	}

	public String getBusStopName() {
		return this.busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public String getBusStopStateCode() {
		return this.busStopStateCode;
	}

	public void setBusStopStateCode(String busStopStateCode) {
		this.busStopStateCode = busStopStateCode;
	}

	public String getBusStopStatus() {
		return this.busStopStatus;
	}

	public void setBusStopStatus(String busStopStatus) {
		this.busStopStatus = busStopStatus;
	}

	public String getLattitude() {
		return this.lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}