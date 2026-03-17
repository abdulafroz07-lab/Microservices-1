package com.amazon.product_service.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazon.product_service.entity.Product;
import com.amazon.product_service.pojos.ProductRequest;
import com.amazon.product_service.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("/checkProduct")
	public Product checkProductService(ProductRequest productRequest) throws Exception {
		Optional<Product> dbData = productRepo.findById(productRequest.getProductID());
		
		if (dbData.isEmpty()) {
			throw new Exception("Product not found");
			
		}
		
		Product product = dbData.get();
		if (productRequest.getQuantity()>product.getStock()) {
			throw new Exception("Products stock not available");
		}
		return product;
	}
	
}
