package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_route_type database table.
 * 
 */
@Entity
@Table(name="mst_route_type")
@NamedQuery(name="RouteTypeEntity.findAll", query="SELECT r FROM RouteTypeEntity r")
public class RouteTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="route_type_id")
	private String routeTypeId;

	@Column(name="route_type_code")
	private String routeTypeCode;

	@Column(name="route_type_name")
	private String routeTypeName;

	public RouteTypeEntity() {
	}

	public String getRouteTypeId() {
		return this.routeTypeId;
	}

	public void setRouteTypeId(String routeTypeId) {
		this.routeTypeId = routeTypeId;
	}

	public String getRouteTypeCode() {
		return this.routeTypeCode;
	}

	public void setRouteTypeCode(String routeTypeCode) {
		this.routeTypeCode = routeTypeCode;
	}

	public String getRouteTypeName() {
		return this.routeTypeName;
	}

	public void setRouteTypeName(String routeTypeName) {
		this.routeTypeName = routeTypeName;
	}

}