package com.practicemicro.inventory_test_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicemicro.inventory_test_service.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/{sku-code}")
	public boolean checkInStock(@PathVariable("sku-code") String skucode) {
		return inventoryService.checkInStock(skucode);
		
	}

}
