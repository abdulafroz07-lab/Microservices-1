package com.amazon.order_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.order_service.entity.Order;
import com.amazon.order_service.pojos.OrderRequest;
import com.amazon.order_service.service.OrderService;

@RestController
@RequestMapping("/Orders/Api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/createOrder")
	public ResponseEntity<?> CreateOrder(@RequestBody OrderRequest orderRequest, @RequestHeader ("Authorization") String jwtToken) throws Exception{
		Order order = orderService.createOrder(orderRequest, jwtToken);
		return ResponseEntity.status(HttpStatus.OK).body(order);
		
	}
	
}
