package com.spring.componentprocessingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PAYMENT-SERVICE")
public interface PaymentProxy {
	
	@GetMapping("/payment-service/{cardNumber}/{cvv}/{cardHolderName}") 
	public String paymentValidation(@PathVariable Long cardNumber, @PathVariable int cvv,
			@PathVariable String cardHolderName);
	
	

}
