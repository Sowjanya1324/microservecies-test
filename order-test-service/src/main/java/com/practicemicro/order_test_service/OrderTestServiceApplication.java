package com.practicemicro.order_test_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderTestServiceApplication.class, args);
	}

}
