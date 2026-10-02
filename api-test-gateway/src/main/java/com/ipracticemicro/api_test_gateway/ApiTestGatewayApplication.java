package com.ipracticemicro.api_test_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiTestGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestGatewayApplication.class, args);
	}

}
