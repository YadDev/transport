package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="waybill_id")
	private String waybillId;

	@Column(name="actual_km")
	private BigDecimal actualKm;

	@Column(name="actual_trip")
	private int actualTrip;

	@Column(name="cash_collect_clerk")
	private String cashCollectClerk;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cash_dep_time")
	private Date cashDepTime;

	@Temporal(TemporalType.DATE)
	@Column(name="duty_date")
	private Date dutyDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="duty_gen_time")
	private Date dutyGenTime;

	@Column(name="duty_id")
	private BigInteger dutyId;

	@Column(name="etim_reg_no")
	private String etimRegNo;

	@Column(name="issue_clerk")
	private String issueClerk;

	@Column(name="rel_version_id")
	private int relVersionId;

	@Column(name="schedule_km")
	private BigDecimal scheduleKm;

	@Column(name="schedule_trip")
	private int scheduleTrip;

	@Column(name="waybill_collect_clerk")
	private String waybillCollectClerk;

	@Column(name="waybill_collect_time")
	private int waybillCollectTime;

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

	@Column(name="waybill_supdriver")
	private int waybillSupdriver;

	@Column(name="waybill_type_id")
	private int waybillTypeId;

	@Column(name="waybill_vehicle")
	private BigInteger waybillVehicle;

	public WaybillEntity() {
	}

	public String getWaybillId() {
		return this.waybillId;
	}

	public void setWaybillId(String waybillId) {
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

	public Date getDutyDate() {
		return this.dutyDate;
	}

	public void setDutyDate(Date dutyDate) {
		this.dutyDate = dutyDate;
	}

	public Date getDutyGenTime() {
		return this.dutyGenTime;
	}

	public void setDutyGenTime(Date dutyGenTime) {
		this.dutyGenTime = dutyGenTime;
	}

	public BigInteger getDutyId() {
		return this.dutyId;
	}

	public void setDutyId(BigInteger dutyId) {
		this.dutyId = dutyId;
	}

	public String getEtimRegNo() {
		return this.etimRegNo;
	}

	public void setEtimRegNo(String etimRegNo) {
		this.etimRegNo = etimRegNo;
	}

	public String getIssueClerk() {
		return this.issueClerk;
	}

	public void setIssueClerk(String issueClerk) {
		this.issueClerk = issueClerk;
	}

	public int getRelVersionId() {
		return this.relVersionId;
	}

	public void setRelVersionId(int relVersionId) {
		this.relVersionId = relVersionId;
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

	public int getWaybillCollectTime() {
		return this.waybillCollectTime;
	}

	public void setWaybillCollectTime(int waybillCollectTime) {
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

	public int getWaybillSupdriver() {
		return this.waybillSupdriver;
	}

	public void setWaybillSupdriver(int waybillSupdriver) {
		this.waybillSupdriver = waybillSupdriver;
	}

	public int getWaybillTypeId() {
		return this.waybillTypeId;
	}

	public void setWaybillTypeId(int waybillTypeId) {
		this.waybillTypeId = waybillTypeId;
	}

	public BigInteger getWaybillVehicle() {
		return this.waybillVehicle;
	}

	public void setWaybillVehicle(BigInteger waybillVehicle) {
		this.waybillVehicle = waybillVehicle;
	}

}