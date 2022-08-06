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
@Table(name="order_response")
@Component
public class OrderResponse {
	
	@Id
	private String requestId;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private String dateOfDelivery;

}
