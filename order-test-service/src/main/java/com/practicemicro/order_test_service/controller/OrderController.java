package com.practicemicro.order_test_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicemicro.order_test_service.dto.OrderRequest;
import com.practicemicro.order_test_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/wish")
	public String getWish() {
		return "Hello User!!!";
	}
	
	@PostMapping("/place-order")
	public String placeOrder(@RequestBody OrderRequest orderReq) {
		orderService.saveOrder(orderReq);
		
		return "Order placed successfully!!";
	}

}
