package com.transport.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="mst_bus_Stop")

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
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
}
