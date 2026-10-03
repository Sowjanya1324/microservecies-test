package com.practicemicro.order_test_service.service;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practicemicro.order_test_service.dto.OrderLineItemDto;
import com.practicemicro.order_test_service.dto.OrderRequest;
import com.practicemicro.order_test_service.model.Order;
import com.practicemicro.order_test_service.model.OrderLineItem;
import com.practicemicro.order_test_service.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/* @Autowired
	private KafkaTemplate<String, String> kafkaTemplate;*/
	
	@Value("${inventory.service-url}")
	private String url;
	
	public void saveOrder(OrderRequest orderReq) {

		List<OrderLineItem> itemsList = orderReq.getOrderLineItems().stream()
		.map(item -> convertToOrderItem(item)).toList();
		Order order = Order.builder()
		.orderNumber(UUID.randomUUID().toString())
		.orderItems(itemsList)
		.build();
		Boolean result = restTemplate.getForEntity(url+"/"+order.getOrderItems().getFirst().getSkuCode(), Boolean.class).getBody();
		System.out.println("reponse from the resttemplte: "+result);
		if(result) {
			orderRepo.save(order);
			// kafkaTemplate.send("order-topic", "The order was successful: "+order.getId());
			// System.out.println("Order event sent to Kafka");
		}
		else {
			throw new IllegalArgumentException("Product not in the stock please try again!!!");
		}
		
		
		
	}
	
	public OrderLineItem convertToOrderItem(OrderLineItemDto item) {
		return OrderLineItem.builder()
		.skuCode(item.getSkuCode())
		.quantity(item.getQuantity())
		.price(item.getPrice())
		.build();
		
	}

}
