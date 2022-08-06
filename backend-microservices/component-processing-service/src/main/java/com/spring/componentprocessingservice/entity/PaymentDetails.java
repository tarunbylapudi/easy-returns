package com.spring.componentprocessingservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_details")
@Component
public class PaymentDetails {
	
	@Id
	private String requestId;
	private double amountToBePaid;
	private long creditCardNumber;
	private Integer cvv;
	private String cardHolderName;
	
	

}
