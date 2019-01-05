package com.transport.transit.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="mst_menu")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MenuMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Integer pageID;
	
	@Column(name="menu_name")
	private String pageName;
	
	@Column(name="menu_seq")
	private Integer pageSeq;
	
	@Column(name="menu_link")
	private String pageLink;
	
	@Column(name="menu_shortcut_key")
	private String pageShortCut;
}
