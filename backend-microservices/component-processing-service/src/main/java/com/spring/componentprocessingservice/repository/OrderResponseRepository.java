package com.spring.componentprocessingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.componentprocessingservice.entity.OrderResponse;

public interface OrderResponseRepository extends JpaRepository<OrderResponse, String>{

}
