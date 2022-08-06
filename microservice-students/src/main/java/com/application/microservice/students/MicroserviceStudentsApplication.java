package com.application.microservice.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.application.microservice.commons.students.models.entity"})
public class MicroserviceStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentsApplication.class, args);
	}

}
