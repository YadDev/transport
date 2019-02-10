package com.transport.transit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.transport.transit.admin.config.AdminJwtFilter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.transport.transit" })
@EntityScan(basePackages = { "com.transport.transit" })
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.transport.transit" })
public class AdminBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(AdminBootStarter.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<AdminJwtFilter> jwtFilter() {
		final FilterRegistrationBean<AdminJwtFilter> registrationBean = new FilterRegistrationBean<AdminJwtFilter>();
		registrationBean.setFilter(new AdminJwtFilter());
		registrationBean.addUrlPatterns("/admin/*");
		return registrationBean;
	}
}
