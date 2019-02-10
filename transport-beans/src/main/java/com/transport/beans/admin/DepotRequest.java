package com.transport.beans.admin;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class DepotRequest {

		private String depotId;
		
		private String depotCode;

		private Date depotCreatedAt;
		
		private int depotCreatedBy;
		
		private String depotName;
		
		private Timestamp depotUpdatedAt;

		private int depotUpdatedBy;
		
		private int relDivisionId;
		
}
