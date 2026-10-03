package com.practicemicro.product_test_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductTestServiceApplication.class, args);
	}

}
