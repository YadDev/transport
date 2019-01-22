package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the mst_submenu database table.
 * 
 */
@Entity
@Table(name="mst_submenu")
@NamedQuery(name="SubMenuEntity.findAll", query="SELECT s FROM SubMenuEntity s")
public class SubMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="rel_menu_id")
	private int relMenuId;

	@Id
	@Column(name="submenu_id")
	private BigInteger submenuId;

	@Column(name="submenu_link")
	private String submenuLink;

	@Column(name="submenu_name")
	private String submenuName;

	@Column(name="submenu_seq")
	private int submenuSeq;

	@Column(name="submenu_shortcut_key")
	private String submenuShortcutKey;

	public SubMenuEntity() {
	}

	public int getRelMenuId() {
		return this.relMenuId;
	}

	public void setRelMenuId(int relMenuId) {
		this.relMenuId = relMenuId;
	}

	public BigInteger getSubmenuId() {
		return this.submenuId;
	}

	public void setSubmenuId(BigInteger submenuId) {
		this.submenuId = submenuId;
	}

	public String getSubmenuLink() {
		return this.submenuLink;
	}

	public void setSubmenuLink(String submenuLink) {
		this.submenuLink = submenuLink;
	}

	public String getSubmenuName() {
		return this.submenuName;
	}

	public void setSubmenuName(String submenuName) {
		this.submenuName = submenuName;
	}

	public int getSubmenuSeq() {
		return this.submenuSeq;
	}

	public void setSubmenuSeq(int submenuSeq) {
		this.submenuSeq = submenuSeq;
	}

	public String getSubmenuShortcutKey() {
		return this.submenuShortcutKey;
	}

	public void setSubmenuShortcutKey(String submenuShortcutKey) {
		this.submenuShortcutKey = submenuShortcutKey;
	}

}