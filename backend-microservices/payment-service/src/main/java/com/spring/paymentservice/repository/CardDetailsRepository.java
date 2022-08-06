package com.spring.paymentservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.paymentservice.entity.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Integer>{

	CardDetails findByCardNumber(Long cardNumber);

}
