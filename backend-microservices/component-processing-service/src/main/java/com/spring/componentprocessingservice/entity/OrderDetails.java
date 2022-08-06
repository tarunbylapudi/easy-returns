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
@Table(name="order_details")
@Component
public class OrderDetails {
	
	@Id
	private String requestId;
	private String userName;
	private String contactNumber;
	private String componentType;
	private String componentName;
	private int quantity;
	
	
	

}
