package com.spring.packagedeliveryservice.entity;

import lombok.Data;

@Data
public class Accessory implements Item {

	private final double deliveryCost=100,packagingCost=50,protectiveSheath=50;
	private final double totalCost=deliveryCost+packagingCost+protectiveSheath;
}
