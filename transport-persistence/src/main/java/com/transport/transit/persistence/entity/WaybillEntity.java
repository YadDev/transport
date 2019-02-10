package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the tsn_waybill database table.
 * 
 */
@Entity
@Table(name="tsn_waybill")
@NamedQuery(name="WaybillEntity.findAll", query="SELECT w FROM WaybillEntity w")
public class WaybillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="waybill_id")
	private BigInteger waybillId;

	@Column(name="actual_km")
	private BigDecimal actualKm;

	@Column(name="actual_trip")
	private int actualTrip;

	@Column(name="cash_collect_clerk")
	private String cashCollectClerk;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cash_dep_time")
	private Date cashDepTime;

	@Column(name="duty_date")
	private String dutyDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="duty_gen_time")
	private Date dutyGenTime;

	@Column(name="issue_clerk")
	private String issueClerk;

	@Column(name="no_of_days")
	private int noOfDays;

	@Column(name="rel_bus_type_id")
	private int relBusTypeId;

	@Column(name="rel_duty_allocation_id")
	private BigInteger relDutyAllocationId;

	@Column(name="rel_etim_no")
	private String relEtimNo;

	@Column(name="rel_extra_reason")
	private int relExtraReason;

	@Column(name="rel_version_id")
	private int relVersionId;

	@Column(name="rel_waybill_status_id")
	private int relWaybillStatusId;

	@Column(name="schedule_km")
	private BigDecimal scheduleKm;

	@Column(name="schedule_trip")
	private int scheduleTrip;

	@Column(name="waybill_collect_clerk")
	private String waybillCollectClerk;

	@Column(name="waybill_collect_time")
	private Timestamp waybillCollectTime;

	@Column(name="waybill_conductor")
	private BigInteger waybillConductor;

	@Column(name="waybill_depot")
	private String waybillDepot;

	@Column(name="waybill_driver")
	private BigInteger waybillDriver;

	@Column(name="waybill_number")
	private String waybillNumber;

	@Column(name="waybill_sup_driver")
	private BigInteger waybillSupDriver;

	@Column(name="waybill_type")
	private String waybillType;

	@Column(name="waybill_vehicle")
	private BigInteger waybillVehicle;

	public WaybillEntity() {
	}

	public BigInteger getWaybillId() {
		return this.waybillId;
	}

	public void setWaybillId(BigInteger waybillId) {
		this.waybillId = waybillId;
	}

	public BigDecimal getActualKm() {
		return this.actualKm;
	}

	public void setActualKm(BigDecimal actualKm) {
		this.actualKm = actualKm;
	}

	public int getActualTrip() {
		return this.actualTrip;
	}

	public void setActualTrip(int actualTrip) {
		this.actualTrip = actualTrip;
	}

	public String getCashCollectClerk() {
		return this.cashCollectClerk;
	}

	public void setCashCollectClerk(String cashCollectClerk) {
		this.cashCollectClerk = cashCollectClerk;
	}

	public Date getCashDepTime() {
		return this.cashDepTime;
	}

	public void setCashDepTime(Date cashDepTime) {
		this.cashDepTime = cashDepTime;
	}

	public String getDutyDate() {
		return this.dutyDate;
	}

	public void setDutyDate(String dutyDate) {
		this.dutyDate = dutyDate;
	}

	public Date getDutyGenTime() {
		return this.dutyGenTime;
	}

	public void setDutyGenTime(Date dutyGenTime) {
		this.dutyGenTime = dutyGenTime;
	}

	public String getIssueClerk() {
		return this.issueClerk;
	}

	public void setIssueClerk(String issueClerk) {
		this.issueClerk = issueClerk;
	}

	public int getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getRelBusTypeId() {
		return this.relBusTypeId;
	}

	public void setRelBusTypeId(int relBusTypeId) {
		this.relBusTypeId = relBusTypeId;
	}

	public BigInteger getRelDutyAllocationId() {
		return this.relDutyAllocationId;
	}

	public void setRelDutyAllocationId(BigInteger relDutyAllocationId) {
		this.relDutyAllocationId = relDutyAllocationId;
	}

	public String getRelEtimNo() {
		return this.relEtimNo;
	}

	public void setRelEtimNo(String relEtimNo) {
		this.relEtimNo = relEtimNo;
	}

	public int getRelExtraReason() {
		return this.relExtraReason;
	}

	public void setRelExtraReason(int relExtraReason) {
		this.relExtraReason = relExtraReason;
	}

	public int getRelVersionId() {
		return this.relVersionId;
	}

	public void setRelVersionId(int relVersionId) {
		this.relVersionId = relVersionId;
	}

	public int getRelWaybillStatusId() {
		return this.relWaybillStatusId;
	}

	public void setRelWaybillStatusId(int relWaybillStatusId) {
		this.relWaybillStatusId = relWaybillStatusId;
	}

	public BigDecimal getScheduleKm() {
		return this.scheduleKm;
	}

	public void setScheduleKm(BigDecimal scheduleKm) {
		this.scheduleKm = scheduleKm;
	}

	public int getScheduleTrip() {
		return this.scheduleTrip;
	}

	public void setScheduleTrip(int scheduleTrip) {
		this.scheduleTrip = scheduleTrip;
	}

	public String getWaybillCollectClerk() {
		return this.waybillCollectClerk;
	}

	public void setWaybillCollectClerk(String waybillCollectClerk) {
		this.waybillCollectClerk = waybillCollectClerk;
	}

	public Timestamp getWaybillCollectTime() {
		return this.waybillCollectTime;
	}

	public void setWaybillCollectTime(Timestamp waybillCollectTime) {
		this.waybillCollectTime = waybillCollectTime;
	}

	public BigInteger getWaybillConductor() {
		return this.waybillConductor;
	}

	public void setWaybillConductor(BigInteger waybillConductor) {
		this.waybillConductor = waybillConductor;
	}

	public String getWaybillDepot() {
		return this.waybillDepot;
	}

	public void setWaybillDepot(String waybillDepot) {
		this.waybillDepot = waybillDepot;
	}

	public BigInteger getWaybillDriver() {
		return this.waybillDriver;
	}

	public void setWaybillDriver(BigInteger waybillDriver) {
		this.waybillDriver = waybillDriver;
	}

	public String getWaybillNumber() {
		return this.waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public BigInteger getWaybillSupDriver() {
		return this.waybillSupDriver;
	}

	public void setWaybillSupDriver(BigInteger waybillSupDriver) {
		this.waybillSupDriver = waybillSupDriver;
	}

	public String getWaybillType() {
		return this.waybillType;
	}

	public void setWaybillType(String waybillType) {
		this.waybillType = waybillType;
	}

	public BigInteger getWaybillVehicle() {
		return this.waybillVehicle;
	}

	public void setWaybillVehicle(BigInteger waybillVehicle) {
		this.waybillVehicle = waybillVehicle;
	}

}