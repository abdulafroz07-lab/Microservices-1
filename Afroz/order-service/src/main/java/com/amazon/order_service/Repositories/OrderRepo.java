package com.amazon.order_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.order_service.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
