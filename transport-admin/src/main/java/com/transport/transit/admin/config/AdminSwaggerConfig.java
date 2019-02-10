package com.transport.transit.admin.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AdminSwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.transport.transit.admin"))
                .paths(regex("/admin.*"))
                .build()
                .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Transport API")
				.description("Transport API reference for developers")
				.termsOfServiceUrl("http://URL.com")
				.contact("abc@gmail.com").license("Transport License")
				.licenseUrl("abc@gmail.com").version("1.0").build();
	}

}