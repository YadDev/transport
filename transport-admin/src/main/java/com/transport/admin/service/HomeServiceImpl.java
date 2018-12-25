package com.transport.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.admin.entity.MenuMaster;
import com.transport.admin.persistence.MenuRepo;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private MenuRepo menus;
	
	
	
	@Override
	public List<MenuMaster> loadMenuMaster(Integer roleID) {
		List<MenuMaster> menuList=new ArrayList<>();	
		menuList=menus.findAll();		
		return menuList;
	}
	

}
