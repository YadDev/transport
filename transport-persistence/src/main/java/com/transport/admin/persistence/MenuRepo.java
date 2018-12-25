package com.transport.admin.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.MenuMaster;

@Repository
public interface MenuRepo extends CrudRepository<MenuMaster,Long> {
	public List<MenuMaster> findAll();
	
}
