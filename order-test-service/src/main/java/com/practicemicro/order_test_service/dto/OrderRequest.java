package com.practicemicro.order_test_service.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	
	private List<OrderLineItemDto> orderLineItems;

}
