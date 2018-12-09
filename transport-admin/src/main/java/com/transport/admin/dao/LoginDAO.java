package com.transport.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.transport.beans.admin.UserCredential;

@Repository
public class LoginDAO implements ILoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public UserCredential findByUserName(String userName) {
		UserCredential userDetail=new UserCredential();
		System.out.println("Query");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * FROM mst_user where user_code='"+userName+"'");
		for (Map row : rows) {
			userDetail.setGetUserId((Integer)row.get("user_id"));
			userDetail.setUserName((String)row.get("user_code"));
			userDetail.setPassword((String)row.get("user_pass"));
						
		}
		return userDetail;
	}

}
