package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_crew_master database table.
 * 
 */
@Entity
@Table(name="mst_crew_master")
@NamedQuery(name="CrewEntity.findAll", query="SELECT c FROM CrewEntity c")
public class CrewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="crew_master_id")
	private String crewMasterId;

	@Temporal(TemporalType.DATE)
	@Column(name="crew_birth_date")
	private Date crewBirthDate;

	@Column(name="crew_card_id")
	private String crewCardId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="crew_created_at")
	private Date crewCreatedAt;

	@Column(name="crew_created_by")
	private int crewCreatedBy;

	@Column(name="crew_middle_name")
	private String crewMiddleName;

	@Column(name="crew_name")
	private String crewName;

	@Column(name="crew_pass")
	private String crewPass;

	@Column(name="crew_surname")
	private String crewSurname;

	@Column(name="crew_updated_at")
	private Timestamp crewUpdatedAt;

	@Column(name="crew_updated_by")
	private int crewUpdatedBy;

	@Column(name="org_unique_id")
	private String orgUniqueId;

	@Column(name="rel_crew_category")
	private int relCrewCategory;

	@Column(name="rel_crew_status")
	private int relCrewStatus;

	@Column(name="rel_crew_type")
	private int relCrewType;

	public CrewEntity() {
	}

	public String getCrewMasterId() {
		return this.crewMasterId;
	}

	public void setCrewMasterId(String crewMasterId) {
		this.crewMasterId = crewMasterId;
	}

	public Date getCrewBirthDate() {
		return this.crewBirthDate;
	}

	public void setCrewBirthDate(Date crewBirthDate) {
		this.crewBirthDate = crewBirthDate;
	}

	public String getCrewCardId() {
		return this.crewCardId;
	}

	public void setCrewCardId(String crewCardId) {
		this.crewCardId = crewCardId;
	}

	public Date getCrewCreatedAt() {
		return this.crewCreatedAt;
	}

	public void setCrewCreatedAt(Date crewCreatedAt) {
		this.crewCreatedAt = crewCreatedAt;
	}

	public int getCrewCreatedBy() {
		return this.crewCreatedBy;
	}

	public void setCrewCreatedBy(int crewCreatedBy) {
		this.crewCreatedBy = crewCreatedBy;
	}

	public String getCrewMiddleName() {
		return this.crewMiddleName;
	}

	public void setCrewMiddleName(String crewMiddleName) {
		this.crewMiddleName = crewMiddleName;
	}

	public String getCrewName() {
		return this.crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public String getCrewPass() {
		return this.crewPass;
	}

	public void setCrewPass(String crewPass) {
		this.crewPass = crewPass;
	}

	public String getCrewSurname() {
		return this.crewSurname;
	}

	public void setCrewSurname(String crewSurname) {
		this.crewSurname = crewSurname;
	}

	public Timestamp getCrewUpdatedAt() {
		return this.crewUpdatedAt;
	}

	public void setCrewUpdatedAt(Timestamp crewUpdatedAt) {
		this.crewUpdatedAt = crewUpdatedAt;
	}

	public int getCrewUpdatedBy() {
		return this.crewUpdatedBy;
	}

	public void setCrewUpdatedBy(int crewUpdatedBy) {
		this.crewUpdatedBy = crewUpdatedBy;
	}

	public String getOrgUniqueId() {
		return this.orgUniqueId;
	}

	public void setOrgUniqueId(String orgUniqueId) {
		this.orgUniqueId = orgUniqueId;
	}

	public int getRelCrewCategory() {
		return this.relCrewCategory;
	}

	public void setRelCrewCategory(int relCrewCategory) {
		this.relCrewCategory = relCrewCategory;
	}

	public int getRelCrewStatus() {
		return this.relCrewStatus;
	}

	public void setRelCrewStatus(int relCrewStatus) {
		this.relCrewStatus = relCrewStatus;
	}

	public int getRelCrewType() {
		return this.relCrewType;
	}

	public void setRelCrewType(int relCrewType) {
		this.relCrewType = relCrewType;
	}

}