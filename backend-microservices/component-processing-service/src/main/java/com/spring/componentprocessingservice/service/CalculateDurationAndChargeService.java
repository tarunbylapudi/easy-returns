package com.spring.componentprocessingservice.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.componentprocessingservice.entity.OrderDetails;
import com.spring.componentprocessingservice.entity.OrderResponse;
import com.spring.componentprocessingservice.entity.PaymentDetails;
import com.spring.componentprocessingservice.exception.ComponentTypeNotFoundException;
import com.spring.componentprocessingservice.proxy.PackageDeliveryProxy;
import com.spring.componentprocessingservice.repository.OrderDetailsRepository;
import com.spring.componentprocessingservice.repository.OrderResponseRepository;
import com.spring.componentprocessingservice.util.AccessoryReplacement;
import com.spring.componentprocessingservice.util.IntegralRepair;
import com.spring.componentprocessingservice.util.ItemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculateDurationAndChargeService {
	
	@Autowired
	OrderResponse orderResponse;
	
	@Autowired
	PaymentDetails paymentDetails;
	
	@Autowired
	OrderResponseRepository orderResponseRepository;

	@Autowired
	PackageDeliveryProxy packageDeliveryProxy;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	private ItemService service;

	public OrderResponse GetProcessingResponse(OrderDetails orderDetails) throws ComponentTypeNotFoundException {
	
			
			//Generating Req ID
			
			String reqID=UUID.randomUUID().toString().replace("-", "").substring(0, 12);
			orderDetails.setRequestId(reqID);
			orderResponse.setRequestId(reqID);
			
			//Saving Order Details to DataBase
			log.info("Order Details saved to data base");
			orderDetailsRepository.save(orderDetails);
			
			
			//getting Processing Charge & Delivery Date
			switch (orderDetails.getComponentType().toLowerCase()) {
			case "integral":
				service = new IntegralRepair();
				break;
			case "accessory":
				service = new AccessoryReplacement();
				break;

			default:
				log.warn("Invalid component type!");
				throw new ComponentTypeNotFoundException("Invalid Component Type");

			}
			
			//Delivery date
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, service.getProcessingDurationInDays());
			orderResponse.setDateOfDelivery(formatter.format(calendar.getTime()) );
			System.out.println(formatter.format(calendar.getTime())+"------->date");
			
			//processing charge
			orderResponse.setProcessingCharge(service.getProcessingCharge() *orderDetails.getQuantity());
			
			//Packaging and deliveryCharge
			double pkgAndDelCharge=packageDeliveryProxy.getcost(orderDetails.getComponentType(), orderDetails.getQuantity());
			log.debug("Invoking packge&Delivery Service");
			orderResponse.setPackagingAndDeliveryCharge(pkgAndDelCharge);
		
			
			//Saving OrderResponse Details to DataBase
			log.info("Order Response Saved to data base");
			orderResponseRepository.save(orderResponse);
			
			return orderResponse;
			

			
		}

}
