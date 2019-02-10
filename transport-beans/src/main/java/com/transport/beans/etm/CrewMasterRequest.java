package com.transport.beans.etm;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class CrewMasterRequest {

	
	private String crewMasterId;

	private Date crewBirthDate;

	private String crewCardId;

	private Date crewCreatedAt;

	private int crewCreatedBy;

	
	private String crewMiddleName;

	
	private String crewName;

	
	private String crewPass;

	
	private String crewSurname;

	
	private Timestamp crewUpdatedAt;

	
	private int crewUpdatedBy;

	private String orgUniqueId;

	
	private int relCrewCategory;

	
	private int relCrewStatus;

	
	private int relCrewType;
	
}
