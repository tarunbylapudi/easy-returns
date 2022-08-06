package com.spring.componentprocessingservice.util;

import lombok.Data;

@Data
public class IntegralRepair implements ItemService {
	
	private int processingDurationInDays=5;
	private double processingCharge=500;
	
}
