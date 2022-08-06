package com.spring.packagedeliveryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.packagedeliveryservice.service.PackageAndDeliveryService;

@RestController
public class CostCaliculationController {
	
	@Autowired
	PackageAndDeliveryService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/package-delivery/componentType/{componentType}/count/{count}")
	public ResponseEntity<Object> getPackagingAndDeliveryCharge(@PathVariable String componentType, @PathVariable int count) throws Exception  {
		
		
		return service.getCost(componentType, count);

	}

}
