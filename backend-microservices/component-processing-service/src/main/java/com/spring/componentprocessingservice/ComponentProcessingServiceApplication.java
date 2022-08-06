package com.spring.componentprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ComponentProcessingServiceApplication {
	
	 

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingServiceApplication.class, args);
	}
	

	


}
