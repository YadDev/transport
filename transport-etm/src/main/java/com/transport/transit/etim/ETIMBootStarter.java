package com.transport.transit.etim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.transport.transit.etim.config.ETIMJwtFilter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.transport.transit" })
@EntityScan(basePackages = { "com.transport.transit" })
@ComponentScan(basePackages = { "com.transport.transit" })
@EnableTransactionManagement
public class ETIMBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(ETIMBootStarter.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<ETIMJwtFilter> jwtFilter() {
		final FilterRegistrationBean<ETIMJwtFilter> registrationBean = new FilterRegistrationBean<ETIMJwtFilter>();
		registrationBean.setFilter(new ETIMJwtFilter());
		registrationBean.addUrlPatterns("/etim/*");
		return registrationBean;
	}
}
