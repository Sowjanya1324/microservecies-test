package com.practicemicro.eureka_server_test_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerTestServiceApplication.class, args);
	}

}
