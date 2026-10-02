package com.ipracticemicro.api_test_gateway.config;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;


@Configuration
public class GatewayConfig {

	@Bean
	public RouterFunction<ServerResponse> productRoutes() {
		return route("product-test-service")
				.route(request -> request.path().startsWith("/api/products"),http())
				.filter(CircuitBreakerFilterFunctions.circuitBreaker("productCircuitBreaker", "/product/fallback"))
                //.before(uri("http://localhost:8081"))
				.filter(lb("product-test-service"))
                .build();
                
	}
	
	@Bean
	public RouterFunction<ServerResponse> orderRoutes(){
		return route("order-test-service")
				.route(request -> request.path().startsWith("/api/orders"), http())
				.filter(CircuitBreakerFilterFunctions.circuitBreaker("orderCB", "/order/fallback"))
				.filter(lb("order-test-service"))
				.build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> inventoryResponse(){
		return route("inventory-test-service")
				.route(request -> request.path().startsWith("/api/inventory"), http())
				.filter(CircuitBreakerFilterFunctions.circuitBreaker("inventoryCB", "/inventory/fallback"))
				.filter(lb("inventory-test-service"))
				.build();
	}
	
}
