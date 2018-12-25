package com.transport.admin.service;

import java.util.List;

import com.transport.admin.entity.MenuMaster;

public interface HomeService {

	public List<MenuMaster> loadMenuMaster(Integer roleID);
	
}
