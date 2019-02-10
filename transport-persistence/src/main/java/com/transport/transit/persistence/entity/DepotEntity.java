package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_depot database table.
 * 
 */
@Entity
@Table(name="mst_depot")
@NamedQuery(name="DepotEntity.findAll", query="SELECT d FROM DepotEntity d")
public class DepotEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="depot_id")
	private String depotId;

	@Column(name="depot_code")
	private String depotCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="depot_created_at")
	private Date depotCreatedAt;

	@Column(name="depot_created_by")
	private int depotCreatedBy;

	@Column(name="depot_name")
	private String depotName;

	@Column(name="depot_updated_at")
	private Timestamp depotUpdatedAt;

	@Column(name="depot_updated_by")
	private int depotUpdatedBy;

	@Column(name="rel_division_id")
	private int relDivisionId;

	public DepotEntity() {
	}

	public String getDepotId() {
		return this.depotId;
	}

	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}

	public String getDepotCode() {
		return this.depotCode;
	}

	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}

	public Date getDepotCreatedAt() {
		return this.depotCreatedAt;
	}

	public void setDepotCreatedAt(Date depotCreatedAt) {
		this.depotCreatedAt = depotCreatedAt;
	}

	public int getDepotCreatedBy() {
		return this.depotCreatedBy;
	}

	public void setDepotCreatedBy(int depotCreatedBy) {
		this.depotCreatedBy = depotCreatedBy;
	}

	public String getDepotName() {
		return this.depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public Timestamp getDepotUpdatedAt() {
		return this.depotUpdatedAt;
	}

	public void setDepotUpdatedAt(Timestamp depotUpdatedAt) {
		this.depotUpdatedAt = depotUpdatedAt;
	}

	public int getDepotUpdatedBy() {
		return this.depotUpdatedBy;
	}

	public void setDepotUpdatedBy(int depotUpdatedBy) {
		this.depotUpdatedBy = depotUpdatedBy;
	}

	public int getRelDivisionId() {
		return this.relDivisionId;
	}

	public void setRelDivisionId(int relDivisionId) {
		this.relDivisionId = relDivisionId;
	}

}