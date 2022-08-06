package com.spring.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.paymentservice.entity.CardDetails;
import com.spring.paymentservice.repository.CardDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardDetailsValidationService {

	@Autowired
	CardDetailsRepository repository;

	public ResponseEntity<String> cardDetailsValidation(Long cardNumber, int cvv, String cardHolderName) {

		log.debug("Fetching the Card Details from the Database for verification");
		CardDetails carddetails = repository.findByCardNumber(cardNumber);

		if (carddetails == null) {

			log.error("Card Not Found!!");

			return new ResponseEntity<>("Card Not Found", HttpStatus.BAD_REQUEST);

		} else if (carddetails.getCvv() == cvv) {

			return new ResponseEntity<>("Payment Successful!", HttpStatus.CREATED);

		}

		else {

			log.error("Incorrect Card Details!, Please Try Again");

			return new ResponseEntity<>("Incorrect Card Details!, Please Try Again", HttpStatus.BAD_REQUEST);

		}

	}

}
