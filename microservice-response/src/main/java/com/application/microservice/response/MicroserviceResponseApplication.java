package com.application.microservice.response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.application.microservice.response.models.entity",
	         "com.application.microservice.commons.students.models.entity",
	         "com.application.microservice.commons.exams.models.entity"})
public class MicroserviceResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceResponseApplication.class, args);
	}

}
