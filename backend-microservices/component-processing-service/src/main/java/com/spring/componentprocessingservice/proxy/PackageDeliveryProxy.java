package com.spring.componentprocessingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PACKAGING-DELIVERY-SERVICE")
public interface PackageDeliveryProxy  {
	
	@GetMapping("/package-delivery/componentType/{componentType}/count/{count}") 
	public double getcost(@PathVariable String componentType,@PathVariable int count);
		
	

}
