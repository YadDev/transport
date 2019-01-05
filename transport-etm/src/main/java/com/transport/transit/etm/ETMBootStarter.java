package com.transport.transit.etm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.transport.transit" })
@EntityScan(basePackages = { "com.transport.transit" })
@ComponentScan(basePackages = { "com.transport.transit" })
public class ETMBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(ETMBootStarter.class, args);
	}
}
