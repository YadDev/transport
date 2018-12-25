package com.transport.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_bus_Stop")
public class BusStopMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="bus_stop_name")
	private String busStopName;
	
	@Column(name="bus_stop_code")
	private String busStopCode;
	
	@Column(name="bus_Stop_add")
	private String busStopAdd;
	
	@Column(name="lattitude")
	private String lattitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="bus_stop_state_code")
	private String busStopState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public String getBusStopCode() {
		return busStopCode;
	}

	public void setBusStopCode(String busStopCode) {
		this.busStopCode = busStopCode;
	}

	public String getBusStopAdd() {
		return busStopAdd;
	}

	public void setBusStopAdd(String busStopAdd) {
		this.busStopAdd = busStopAdd;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getBusStopState() {
		return busStopState;
	}

	public void setBusStopState(String busStopState) {
		this.busStopState = busStopState;
	}

	@Override
	public String toString() {
		return "BusStopMaster [id=" + id + ", busStopName=" + busStopName + ", busStopCode=" + busStopCode
				+ ", busStopAdd=" + busStopAdd + ", lattitude=" + lattitude + ", longitude=" + longitude
				+ ", busStopState=" + busStopState + "]";
	}
	
	
	

}
