package com.transport.admin.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.transport.admin.entity.UserCredential;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserCredential findByUserName(String userName) {
		UserCredential userDetail=new UserCredential();
		System.out.println("Query");
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * FROM mst_user where user_code='"+userName+"'");
		for (Map row : rows) {
			userDetail.setUserId((Integer)row.get("user_id"));
			userDetail.setUserName((String)row.get("user_code"));
			userDetail.setPassword((String)row.get("user_pass"));
						
		}
		return userDetail;
	}

}
