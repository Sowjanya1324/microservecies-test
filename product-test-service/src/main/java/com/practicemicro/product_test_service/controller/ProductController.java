package com.practicemicro.product_test_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicemicro.product_test_service.dto.ProductRequest;
import com.practicemicro.product_test_service.dto.ProductResponse;
import com.practicemicro.product_test_service.model.Product;
import com.practicemicro.product_test_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable(name ="productId") long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/createprod")
	public ResponseEntity<String> saveProduct(@RequestBody ProductRequest prod) {
		Long saveProdId = productService.saveProduct(prod);
		return ResponseEntity.status(HttpStatus.CREATED).body("Prodcut Created with Id: "+saveProdId);
		
	}

}
