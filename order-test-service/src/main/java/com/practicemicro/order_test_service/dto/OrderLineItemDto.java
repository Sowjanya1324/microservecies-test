package com.practicemicro.order_test_service.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderLineItemDto {
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

}
