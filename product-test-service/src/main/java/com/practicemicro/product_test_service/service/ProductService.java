package com.practicemicro.product_test_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicemicro.product_test_service.dto.ProductRequest;
import com.practicemicro.product_test_service.dto.ProductResponse;
import com.practicemicro.product_test_service.model.Product;
import com.practicemicro.product_test_service.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<ProductResponse> getAllProducts() {
		List<Product> allProd = productRepo.findAll();
		return allProd.stream().map(item -> convertToProdResponse(item)).toList();
		
	}

	private ProductResponse convertToProdResponse(Product item) {
		return ProductResponse.builder()
		.id(item.getId())
		.name(item.getName())
		.description(item.getDescription())
		.price(item.getPrice())
		.build();
	}

	public Product getProductById(long id) {
		Product prod = productRepo.findById(id).orElse(null);
		return prod;
	}

	public Long saveProduct(ProductRequest prod) {
		Product product = Product.builder()
		.name(prod.getName())
		.description(prod.getDescription())
		.price(prod.getPrice())
		.build();
		Product savedProd = productRepo.save(product);
		return savedProd.getId();
	}

}
