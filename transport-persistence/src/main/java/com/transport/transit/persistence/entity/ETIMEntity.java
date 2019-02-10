package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the mst_etimhh_master database table.
 * 
 */
@Entity
@Table(name="mst_etimhh_master")
@NamedQuery(name="ETIMEntity.findAll", query="SELECT e FROM ETIMEntity e")
public class ETIMEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="etim_id")
	private String etimId;

	@Column(name="etim_available_id")
	private int etimAvailableId;

	@Column(name="etim_ccid")
	private String etimCcid;

	@Column(name="etim_depot_id")
	private BigInteger etimDepotId;

	@Column(name="etim_imsi")
	private String etimImsi;

	@Column(name="etim_number")
	private String etimNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="etim_register_at")
	private Date etimRegisterAt;

	@Column(name="etim_register_by")
	private int etimRegisterBy;

	@Column(name="etim_serial_number")
	private String etimSerialNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="etim_version_date")
	private Date etimVersionDate;

	@Column(name="etim_version_id")
	private int etimVersionId;

	@Column(name="etim_working_status")
	private String etimWorkingStatus;

	public ETIMEntity() {
	}

	public String getEtimId() {
		return this.etimId;
	}

	public void setEtimId(String etimId) {
		this.etimId = etimId;
	}

	public int getEtimAvailableId() {
		return this.etimAvailableId;
	}

	public void setEtimAvailableId(int etimAvailableId) {
		this.etimAvailableId = etimAvailableId;
	}

	public String getEtimCcid() {
		return this.etimCcid;
	}

	public void setEtimCcid(String etimCcid) {
		this.etimCcid = etimCcid;
	}

	public BigInteger getEtimDepotId() {
		return this.etimDepotId;
	}

	public void setEtimDepotId(BigInteger etimDepotId) {
		this.etimDepotId = etimDepotId;
	}

	public String getEtimImsi() {
		return this.etimImsi;
	}

	public void setEtimImsi(String etimImsi) {
		this.etimImsi = etimImsi;
	}

	public String getEtimNumber() {
		return this.etimNumber;
	}

	public void setEtimNumber(String etimNumber) {
		this.etimNumber = etimNumber;
	}

	public Date getEtimRegisterAt() {
		return this.etimRegisterAt;
	}

	public void setEtimRegisterAt(Date etimRegisterAt) {
		this.etimRegisterAt = etimRegisterAt;
	}

	public int getEtimRegisterBy() {
		return this.etimRegisterBy;
	}

	public void setEtimRegisterBy(int etimRegisterBy) {
		this.etimRegisterBy = etimRegisterBy;
	}

	public String getEtimSerialNumber() {
		return this.etimSerialNumber;
	}

	public void setEtimSerialNumber(String etimSerialNumber) {
		this.etimSerialNumber = etimSerialNumber;
	}

	public Date getEtimVersionDate() {
		return this.etimVersionDate;
	}

	public void setEtimVersionDate(Date etimVersionDate) {
		this.etimVersionDate = etimVersionDate;
	}

	public int getEtimVersionId() {
		return this.etimVersionId;
	}

	public void setEtimVersionId(int etimVersionId) {
		this.etimVersionId = etimVersionId;
	}

	public String getEtimWorkingStatus() {
		return this.etimWorkingStatus;
	}

	public void setEtimWorkingStatus(String etimWorkingStatus) {
		this.etimWorkingStatus = etimWorkingStatus;
	}

}