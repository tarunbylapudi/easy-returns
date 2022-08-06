package com.spring.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="card_details")
public class CardDetails {
	
	@Id
	private int sNo;
	private long cardNumber;
	private int cvv;
	private String cardHolderName;

}
