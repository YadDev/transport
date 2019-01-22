package com.transport.beans.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CreateMenuRequest {
	private int pageID;
	private String pageName;
	private String pageLink;
	private int pageSeq;
	private String pageShortCut;
}
