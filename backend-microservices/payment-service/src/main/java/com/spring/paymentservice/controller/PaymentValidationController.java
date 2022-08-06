package com.spring.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.paymentservice.service.CardDetailsValidationService;

@RestController
public class PaymentValidationController {

	@Autowired
	CardDetailsValidationService service;

	@GetMapping("/payment-service/{cardNumber}/{cvv}/{cardHolderName}")
	
	public ResponseEntity<String> paymentValidation(@PathVariable Long cardNumber, @PathVariable int cvv,
			@PathVariable String cardHolderName) {

		return service.cardDetailsValidation(cardNumber, cvv, cardHolderName);
			
		
		
	
	}
	
	

}
