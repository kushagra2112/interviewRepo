package com.tata.aia;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App {
	private static final Contact DEFAULT_CONTACT = null;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/policy/*"))
				.apis(RequestHandlerSelectors.basePackage("com.tata.aia."))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Sample Policy Management API",
				"Api Documentation", "1.0", "urn:tos",
		        new springfox.documentation.service.Contact("Kushagra Agrawal", "", "kushagra2112@gmail.com/kushagra21121994@gmail.com") 
				, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
				Collections.emptyList());
		
	}
}
