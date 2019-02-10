package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_region database table.
 * 
 */
@Entity
@Table(name="mst_region")
@NamedQuery(name="RegionEntity.findAll", query="SELECT r FROM RegionEntity r")
public class RegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="region_id")
	private int regionId;

	@Column(name="region_code")
	private String regionCode;

	@Column(name="region_name")
	private String regionName;

	@Column(name="rel_organization_id")
	private int relOrganizationId;

	public RegionEntity() {
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getRelOrganizationId() {
		return this.relOrganizationId;
	}

	public void setRelOrganizationId(int relOrganizationId) {
		this.relOrganizationId = relOrganizationId;
	}

}