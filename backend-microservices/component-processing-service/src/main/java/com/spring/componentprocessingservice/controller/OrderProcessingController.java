package com.spring.componentprocessingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.spring.componentprocessingservice.entity.OrderDetails;
import com.spring.componentprocessingservice.entity.OrderResponse;
import com.spring.componentprocessingservice.entity.PaymentDetails;
import com.spring.componentprocessingservice.proxy.AuthenticationProxy;
import com.spring.componentprocessingservice.proxy.PaymentProxy;
import com.spring.componentprocessingservice.service.CalculateDurationAndChargeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderProcessingController {

	@Autowired
	PaymentDetails pamentdetails;

	@Autowired
	AuthenticationProxy authenticationProxy;

	@Autowired
	PaymentProxy paymentProxy;

	@Autowired
	CalculateDurationAndChargeService service;

	@CrossOrigin(origins = "*")
	@GetMapping("/component-processing")
	
	public ResponseEntity<OrderResponse> processDetail(@RequestHeader("Authorization") String token,
			OrderDetails orderdetails) throws Exception {

		log.debug("Invoking Token Validation Service");
		authenticationProxy.authorize(token);

		return new ResponseEntity<>(service.GetProcessingResponse(orderdetails), HttpStatus.OK);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/payment-processing")
	public String completeProcessing(@RequestHeader("Authorization") String token,
			@RequestBody PaymentDetails paymentdetails) throws Exception {

		log.debug("Invoking Token Validation Service");

		authenticationProxy.authorize(token);

		return paymentProxy.paymentValidation(paymentdetails.getCreditCardNumber(), paymentdetails.getCvv(),
				paymentdetails.getCardHolderName());

	}
	
	

}
