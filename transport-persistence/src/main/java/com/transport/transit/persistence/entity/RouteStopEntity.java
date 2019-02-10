package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the mst_route_stops database table.
 * 
 */
@Entity
@Table(name="mst_route_stops")
@NamedQuery(name="RouteStopEntity.findAll", query="SELECT r FROM RouteStopEntity r")
public class RouteStopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="enroute_stop_id")
	private String enrouteStopId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="enroute_created_at")
	private Date enrouteCreatedAt;

	@Column(name="enroute_created_by")
	private int enrouteCreatedBy;

	@Column(name="enroute_latitute")
	private double enrouteLatitute;

	@Column(name="enroute_longitute")
	private double enrouteLongitute;

	@Column(name="enroute_stop_code")
	private String enrouteStopCode;

	@Column(name="enroute_stop_seq")
	private int enrouteStopSeq;

	@Column(name="enroute_updated_at")
	private Timestamp enrouteUpdatedAt;

	@Column(name="enroute_updated_by")
	private int enrouteUpdatedBy;

	@Column(name="interstate_km")
	private BigDecimal interstateKm;

	@Column(name="interstate_stop")
	private String interstateStop;

	@Column(name="intrastate_km")
	private BigDecimal intrastateKm;

	@Column(name="km_from_first")
	private BigDecimal kmFromFirst;

	@Column(name="rel_routestop_id")
	private BigInteger relRoutestopId;

	@Column(name="reservation_stop")
	private String reservationStop;

	@Column(name="stage_no")
	private String stageNo;

	@Column(name="stop_active_status")
	private String stopActiveStatus;

	@Column(name="substage_no")
	private String substageNo;

	//bi-directional many-to-one association to RouteEntity
	@ManyToOne
	@JoinColumn(name="rel_route_id")
	private RouteEntity mstRoute;

	public RouteStopEntity() {
	}

	public String getEnrouteStopId() {
		return this.enrouteStopId;
	}

	public void setEnrouteStopId(String enrouteStopId) {
		this.enrouteStopId = enrouteStopId;
	}

	public Date getEnrouteCreatedAt() {
		return this.enrouteCreatedAt;
	}

	public void setEnrouteCreatedAt(Date enrouteCreatedAt) {
		this.enrouteCreatedAt = enrouteCreatedAt;
	}

	public int getEnrouteCreatedBy() {
		return this.enrouteCreatedBy;
	}

	public void setEnrouteCreatedBy(int enrouteCreatedBy) {
		this.enrouteCreatedBy = enrouteCreatedBy;
	}

	public double getEnrouteLatitute() {
		return this.enrouteLatitute;
	}

	public void setEnrouteLatitute(double enrouteLatitute) {
		this.enrouteLatitute = enrouteLatitute;
	}

	public double getEnrouteLongitute() {
		return this.enrouteLongitute;
	}

	public void setEnrouteLongitute(double enrouteLongitute) {
		this.enrouteLongitute = enrouteLongitute;
	}

	public String getEnrouteStopCode() {
		return this.enrouteStopCode;
	}

	public void setEnrouteStopCode(String enrouteStopCode) {
		this.enrouteStopCode = enrouteStopCode;
	}

	public int getEnrouteStopSeq() {
		return this.enrouteStopSeq;
	}

	public void setEnrouteStopSeq(int enrouteStopSeq) {
		this.enrouteStopSeq = enrouteStopSeq;
	}

	public Timestamp getEnrouteUpdatedAt() {
		return this.enrouteUpdatedAt;
	}

	public void setEnrouteUpdatedAt(Timestamp enrouteUpdatedAt) {
		this.enrouteUpdatedAt = enrouteUpdatedAt;
	}

	public int getEnrouteUpdatedBy() {
		return this.enrouteUpdatedBy;
	}

	public void setEnrouteUpdatedBy(int enrouteUpdatedBy) {
		this.enrouteUpdatedBy = enrouteUpdatedBy;
	}

	public BigDecimal getInterstateKm() {
		return this.interstateKm;
	}

	public void setInterstateKm(BigDecimal interstateKm) {
		this.interstateKm = interstateKm;
	}

	public String getInterstateStop() {
		return this.interstateStop;
	}

	public void setInterstateStop(String interstateStop) {
		this.interstateStop = interstateStop;
	}

	public BigDecimal getIntrastateKm() {
		return this.intrastateKm;
	}

	public void setIntrastateKm(BigDecimal intrastateKm) {
		this.intrastateKm = intrastateKm;
	}

	public BigDecimal getKmFromFirst() {
		return this.kmFromFirst;
	}

	public void setKmFromFirst(BigDecimal kmFromFirst) {
		this.kmFromFirst = kmFromFirst;
	}

	public BigInteger getRelRoutestopId() {
		return this.relRoutestopId;
	}

	public void setRelRoutestopId(BigInteger relRoutestopId) {
		this.relRoutestopId = relRoutestopId;
	}

	public String getReservationStop() {
		return this.reservationStop;
	}

	public void setReservationStop(String reservationStop) {
		this.reservationStop = reservationStop;
	}

	public String getStageNo() {
		return this.stageNo;
	}

	public void setStageNo(String stageNo) {
		this.stageNo = stageNo;
	}

	public String getStopActiveStatus() {
		return this.stopActiveStatus;
	}

	public void setStopActiveStatus(String stopActiveStatus) {
		this.stopActiveStatus = stopActiveStatus;
	}

	public String getSubstageNo() {
		return this.substageNo;
	}

	public void setSubstageNo(String substageNo) {
		this.substageNo = substageNo;
	}

	public RouteEntity getMstRoute() {
		return this.mstRoute;
	}

	public void setMstRoute(RouteEntity mstRoute) {
		this.mstRoute = mstRoute;
	}

}