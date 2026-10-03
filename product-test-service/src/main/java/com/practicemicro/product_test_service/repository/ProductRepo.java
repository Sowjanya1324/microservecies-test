package com.practicemicro.product_test_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicemicro.product_test_service.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
