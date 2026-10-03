package com.practicemicro.inventory_test_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicemicro.inventory_test_service.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepo;

	public boolean checkInStock(String skucode) {
		return inventoryRepo.findBySkuCode(skucode).isPresent();
		
	}

}
