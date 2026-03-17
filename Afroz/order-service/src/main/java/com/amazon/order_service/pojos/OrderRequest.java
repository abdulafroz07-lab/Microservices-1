package com.amazon.order_service.pojos;

import lombok.Data;

@Data
public class OrderRequest {

	private int productId;
	private String price; 
	private int stock; 
	private String orderStatu;
}
