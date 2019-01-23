package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_routes database table.
 * 
 */
@Entity
@Table(name="mst_routes")
@NamedQuery(name="MstRoute.findAll", query="SELECT m FROM MstRoute m")
public class MstRoute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="route_id")
	private String routeId;

	@Column(name="rel_org_id")
	private int relOrgId;

	@Column(name="rel_route_code")
	private String relRouteCode;

	@Column(name="rel_route_type")
	private int relRouteType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="route_created_at")
	private Date routeCreatedAt;

	@Column(name="route_created_by")
	private int routeCreatedBy;

	@Column(name="route_from_stop")
	private String routeFromStop;

	@Column(name="route_km")
	private BigDecimal routeKm;

	@Column(name="route_name")
	private String routeName;

	@Column(name="route_org_no")
	private String routeOrgNo;

	@Column(name="route_state_five")
	private int routeStateFive;

	@Column(name="route_state_four")
	private int routeStateFour;

	@Column(name="route_state_one")
	private int routeStateOne;

	@Column(name="route_state_three")
	private int routeStateThree;

	@Column(name="route_state_two")
	private int routeStateTwo;

	@Column(name="route_status")
	private String routeStatus;

	@Column(name="route_to_stop")
	private String routeToStop;

	@Column(name="route_under")
	private String routeUnder;

	@Column(name="route_up_dn_flag")
	private String routeUpDnFlag;

	@Column(name="route_updated_at")
	private Timestamp routeUpdatedAt;

	@Column(name="route_updated_by")
	private int routeUpdatedBy;

	@Column(name="route_via_stop")
	private String routeViaStop;

	public MstRoute() {
	}

	public String getRouteId() {
		return this.routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public int getRelOrgId() {
		return this.relOrgId;
	}

	public void setRelOrgId(int relOrgId) {
		this.relOrgId = relOrgId;
	}

	public String getRelRouteCode() {
		return this.relRouteCode;
	}

	public void setRelRouteCode(String relRouteCode) {
		this.relRouteCode = relRouteCode;
	}

	public int getRelRouteType() {
		return this.relRouteType;
	}

	public void setRelRouteType(int relRouteType) {
		this.relRouteType = relRouteType;
	}

	public Date getRouteCreatedAt() {
		return this.routeCreatedAt;
	}

	public void setRouteCreatedAt(Date routeCreatedAt) {
		this.routeCreatedAt = routeCreatedAt;
	}

	public int getRouteCreatedBy() {
		return this.routeCreatedBy;
	}

	public void setRouteCreatedBy(int routeCreatedBy) {
		this.routeCreatedBy = routeCreatedBy;
	}

	public String getRouteFromStop() {
		return this.routeFromStop;
	}

	public void setRouteFromStop(String routeFromStop) {
		this.routeFromStop = routeFromStop;
	}

	public BigDecimal getRouteKm() {
		return this.routeKm;
	}

	public void setRouteKm(BigDecimal routeKm) {
		this.routeKm = routeKm;
	}

	public String getRouteName() {
		return this.routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteOrgNo() {
		return this.routeOrgNo;
	}

	public void setRouteOrgNo(String routeOrgNo) {
		this.routeOrgNo = routeOrgNo;
	}

	public int getRouteStateFive() {
		return this.routeStateFive;
	}

	public void setRouteStateFive(int routeStateFive) {
		this.routeStateFive = routeStateFive;
	}

	public int getRouteStateFour() {
		return this.routeStateFour;
	}

	public void setRouteStateFour(int routeStateFour) {
		this.routeStateFour = routeStateFour;
	}

	public int getRouteStateOne() {
		return this.routeStateOne;
	}

	public void setRouteStateOne(int routeStateOne) {
		this.routeStateOne = routeStateOne;
	}

	public int getRouteStateThree() {
		return this.routeStateThree;
	}

	public void setRouteStateThree(int routeStateThree) {
		this.routeStateThree = routeStateThree;
	}

	public int getRouteStateTwo() {
		return this.routeStateTwo;
	}

	public void setRouteStateTwo(int routeStateTwo) {
		this.routeStateTwo = routeStateTwo;
	}

	public String getRouteStatus() {
		return this.routeStatus;
	}

	public void setRouteStatus(String routeStatus) {
		this.routeStatus = routeStatus;
	}

	public String getRouteToStop() {
		return this.routeToStop;
	}

	public void setRouteToStop(String routeToStop) {
		this.routeToStop = routeToStop;
	}

	public String getRouteUnder() {
		return this.routeUnder;
	}

	public void setRouteUnder(String routeUnder) {
		this.routeUnder = routeUnder;
	}

	public String getRouteUpDnFlag() {
		return this.routeUpDnFlag;
	}

	public void setRouteUpDnFlag(String routeUpDnFlag) {
		this.routeUpDnFlag = routeUpDnFlag;
	}

	public Timestamp getRouteUpdatedAt() {
		return this.routeUpdatedAt;
	}

	public void setRouteUpdatedAt(Timestamp routeUpdatedAt) {
		this.routeUpdatedAt = routeUpdatedAt;
	}

	public int getRouteUpdatedBy() {
		return this.routeUpdatedBy;
	}

	public void setRouteUpdatedBy(int routeUpdatedBy) {
		this.routeUpdatedBy = routeUpdatedBy;
	}

	public String getRouteViaStop() {
		return this.routeViaStop;
	}

	public void setRouteViaStop(String routeViaStop) {
		this.routeViaStop = routeViaStop;
	}

}