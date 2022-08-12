package com.application.microservice.commons.exams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceExamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExamsApplication.class, args);
	}

}
