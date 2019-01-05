package com.transport.transit.persistence.entity;

import java.util.Date;

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
@Table(name="tsn_waybill")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class WaybillEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="waybill_id")	
	private Integer waybillID;
	
	@Column(name="waybill_number")
	private String waybillNumber;
	
	@Column(name="waybill_depot")
	private String waybillDepot;
	
	@Column(name="waybill_vehicle")
	private Integer waybillVehicle;
	
	@Column(name="waybill_conductor")
	private Integer waybillConductor;
	
	@Column(name="waybill_driver")
	private Integer waybillDriver;
	
	@Column(name="waybill_sup_driver")
	private Integer waybillSupDriver;
	
	@Column(name="duty_date")
	private Date dutyDate;
	
	@Column(name="duty_id")
	private Integer dutyID;
	
	@Column(name="etim_reg_no")
	private String etmRegNo;
	
	@Column(name="rel_version_id")
	private Integer relVersionID;
	
	@Column(name="waybill_type_id")
	private Integer waybillTypeID;
	
	@Column(name="schedule_trip")
	private Integer scheduleTrip;
	
	@Column(name="actual_trip")
	private Integer actualTrip;
	
	@Column(name="schedule_km")
	private Float scheduleKM;
	
	@Column(name="actual_km")
	private Float actualKM;
	
	@Column(name="duty_gen_time")
	private Date dutyGenTime;
	
	@Column(name="cash_dep_time")
	private Date cashDepTime;
	
	@Column(name="waybill_collect_time")
	private Integer waybillCollectTime;
	
	@Column(name="issue_clerk")
	private String issueClerk;
	
	@Column(name="cash_collect_clerk")
	private String cashCollectClerk;
	
	@Column(name="waybill_collect_clerk")
	private String waybillCollectClerk;
	
	
}
