package com.practicemicro.product_test_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;

}
