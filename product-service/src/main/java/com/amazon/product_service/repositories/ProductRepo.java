package com.amazon.product_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.product_service.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
