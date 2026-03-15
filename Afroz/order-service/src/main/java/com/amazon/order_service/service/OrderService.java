package com.amazon.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.amazon.order_service.Repositories.OrderRepo;
import com.amazon.order_service.entity.Order;
import com.amazon.order_service.pojos.OrderRequest;

@Service
public class OrderService {

	@Autowired
	WebClient webClient;
	
	
	@Autowired
	OrderRepo orderRepo;
	
	public Order createOrder(OrderRequest orderRequest, String jwtToken) throws Exception {
		
		Boolean isTokenValid = webClient.get().uri("http://localhost:8081/auth/api/ValidatingJWT").header("Authorization",jwtToken)
		.retrieve().bodyToMono(Boolean.class).block();
		
		if (isTokenValid = true) {
			
		Order order = new Order();
		
		order.setOrderStatu(orderRequest.getOrderStatu());
		order.setProductId(orderRequest.getProductId());
		order.setPrice(orderRequest.getPrice());
		order.setStock(orderRequest.getStock());
	
		orderRepo.save(order);
		return order;
		}else {
			throw new Exception("NotValid");
		}
	}
}
