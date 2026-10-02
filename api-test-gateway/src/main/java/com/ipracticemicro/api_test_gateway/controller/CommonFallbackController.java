package com.ipracticemicro.api_test_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonFallbackController {
	
	@GetMapping("/product/fallback")
	public String productFallback() {
		return "Having Problem with Product-Test-Service, Please try again!!!";
	}
	
	@GetMapping("/order/fallback")
	public String orderFallback() {
		return "Order Service is currently not available.please try again!!";
	}
	
	@GetMapping("/inventory/fallback")
	public String inventoryFallback() {
		return "Inventroy Service not available.please try after some time...";
	}
}
