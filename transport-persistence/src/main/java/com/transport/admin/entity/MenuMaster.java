package com.transport.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_menu")
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
	
	public Integer getPageID() {
		return pageID;
	}
	public void setPageID(Integer pageID) {
		this.pageID = pageID;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public Integer getPageSeq() {
		return pageSeq;
	}
	public void setPageSeq(Integer pageSeq) {
		this.pageSeq = pageSeq;
	}
	public String getPageLink() {
		return pageLink;
	}
	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	public String getPageShortCut() {
		return pageShortCut;
	}
	public void setPageShortCut(String pageShortCut) {
		this.pageShortCut = pageShortCut;
	}
	
	
	
}
