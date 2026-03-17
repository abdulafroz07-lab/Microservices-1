package com.amazon.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.product_service.entity.Product;
import com.amazon.product_service.pojos.ProductRequest;
import com.amazon.product_service.service.ProductService;

@RestController
@RequestMapping("/Productservice/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	public ResponseEntity<?> checkProduct(@RequestBody ProductRequest productRequest) throws Exception{
		Product product = productService.checkProductService(productRequest);
		return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
	
}
