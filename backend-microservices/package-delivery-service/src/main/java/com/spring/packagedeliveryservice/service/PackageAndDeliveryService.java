package com.spring.packagedeliveryservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.packagedeliveryservice.entity.Accessory;
import com.spring.packagedeliveryservice.entity.IntegralItem;
import com.spring.packagedeliveryservice.entity.Item;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PackageAndDeliveryService {

	private Item item;

	public ResponseEntity<Object> getCost(String componentType, int count) {

		if (count <= 0) {
			log.error("Count Should be Grater than 0!");

			return new ResponseEntity<>("Quantity Should be Greater than 0!", HttpStatus.BAD_REQUEST);

		} else {
			switch (componentType.toLowerCase()) {

			case "integral":
				item = new IntegralItem();

				break;

			case "accessory":
				item = new Accessory();
				break;

			default:
				log.error("Invalid Component Type");
				return new ResponseEntity<>("Invalid Component Type", HttpStatus.BAD_REQUEST);

			}

			return new ResponseEntity<>(item.getTotalCost() * count, HttpStatus.OK);

		}

	}

}
