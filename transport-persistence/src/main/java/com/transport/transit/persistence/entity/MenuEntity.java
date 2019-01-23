package com.transport.transit.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_menu database table.
 * 
 */
@Entity
@Table(name="mst_menu")
@NamedQuery(name="MenuEntity.findAll", query="SELECT m FROM MenuEntity m")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id")
	private int menuId;

	@Column(name="menu_link")
	private String menuLink;

	@Column(name="menu_name")
	private String menuName;

	@Column(name="menu_seq")
	private int menuSeq;

	@Column(name="menu_shortcut_key")
	private String menuShortcutKey;

	public MenuEntity() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuLink() {
		return this.menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuSeq() {
		return this.menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getMenuShortcutKey() {
		return this.menuShortcutKey;
	}

	public void setMenuShortcutKey(String menuShortcutKey) {
		this.menuShortcutKey = menuShortcutKey;
	}

}