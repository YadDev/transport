package com.transport.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.transport.admin.config.JwtFilter;

@SpringBootApplication
@EntityScan(basePackages = { "com.transport" })
@ComponentScan(basePackages = { "com.transport" })
public class AdminBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(AdminBootStarter.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");
		return registrationBean;
	}
}
