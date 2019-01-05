package com.transport.transit.persistence.config;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Configuration
@EnableAutoConfiguration
public class BeanConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);
	
	@Value("${spring.datasource.url}")
	private String dbURL;
	
	@Value("${spring.datasource.username}")
	private String dbUsername;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriverClass;
	
	@Bean()
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		logger.info("Coonecting to the Database");
		dataSource.setUrl(dbURL);
		dataSource.setPassword(dbPassword);
		dataSource.setUsername(dbUsername);
		dataSource.setDriverClassName(dbDriverClass);
		logger.info("Connected to the database");
		return dataSource;
	}
	
	@Bean()
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	
	@Bean()
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean()
	public TransactionDefinition transactionDefination(){
		return new  DefaultTransactionDefinition();
	}
	

}
