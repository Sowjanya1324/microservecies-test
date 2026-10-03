package com.practicemicro.order_test_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicemicro.order_test_service.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
