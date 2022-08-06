package com.spring.packagedeliveryservice.entity;

import lombok.Data;

@Data
public class IntegralItem implements Item {

	private final double deliveryCost = 200, packagingCost = 100, protectiveSheath = 50;

	private final double totalCost=deliveryCost+packagingCost+protectiveSheath;

	
	}


