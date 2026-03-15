package com.amazon.order_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int orderId;
	private int productId;
	private String price; 
	private int stock; 
	private String orderStatu;
	private LocalDateTime createdOn =  LocalDateTime.now();
	private LocalDateTime updatedOn =  LocalDateTime.now();
	
	
}
