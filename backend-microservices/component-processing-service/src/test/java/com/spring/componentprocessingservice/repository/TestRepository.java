package com.spring.componentprocessingservice.repository;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.componentprocessingservice.entity.OrderDetails;
import com.spring.componentprocessingservice.entity.OrderResponse;


@SpringBootTest
class TestRepository {
	@Autowired
	OrderResponseRepository orderResponseRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
/*
 * This method is used to test whether request request details are saved to repo or not
 */
	@Test
	void isProcessRequestSaved() {
		
		OrderDetails orderDetails = new OrderDetails("requestID123","HeyUserIamDuplicate", "815487890", "Integral", "Lappy", 5);
		orderDetails=orderDetailsRepository.save(orderDetails);
		boolean isNotnull =orderDetailsRepository.findById(orderDetails.getRequestId())!=null;
		assertThat(isNotnull).isTrue();
		orderDetailsRepository.deleteById(orderDetails.getRequestId());
	}
	/*
	 * This method is used to test whether response request details are saved to repo or not
	 */
	@Test
	void isProcessResponseSaved() {
		String id = UUID.randomUUID().toString();
		OrderResponse orderResponse = new OrderResponse(id, 250, 380,"date_string");
		boolean isNotnull =orderResponseRepository.save(orderResponse)!=null;
		assertThat(isNotnull).isTrue();
		orderResponseRepository.deleteById(id);	}

}