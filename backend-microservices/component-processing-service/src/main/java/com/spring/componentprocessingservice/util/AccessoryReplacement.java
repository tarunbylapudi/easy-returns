package com.spring.componentprocessingservice.util;

import lombok.Data;

@Data
public class AccessoryReplacement implements ItemService {
	
	private final int processingDurationInDays=2;
	private final double processingCharge=300;
	
	
	

}
