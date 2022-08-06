package com.spring.componentprocessingservice.exception;

import java.net.ConnectException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.Feign;
import feign.FeignException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ComponentTypeNotFoundException.class)
	public final ResponseEntity<Object> handleException(ComponentTypeNotFoundException ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(FeignException.Forbidden.class)
	public final ResponseEntity<Object> handleException(FeignException.Forbidden ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), "Session TimeOut, Please Login Again!", request.getDescription(false));

		return new ResponseEntity<>(e, HttpStatus.valueOf(ex.status()));

	}

	@ExceptionHandler(FeignException.BadRequest.class)
	public final ResponseEntity<Object> handleException(FeignException.BadRequest ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(e, HttpStatus.valueOf(ex.status()));

	}

	@ExceptionHandler(FeignException.ServiceUnavailable.class)
	public final ResponseEntity<Object> handleException(FeignException.ServiceUnavailable ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), " Server is down, Please Retry after Sometime",
				request.getDescription(false));

		return new ResponseEntity<>(e, HttpStatus.valueOf(ex.status()));

	}
	@ExceptionHandler(feign.RetryableException.class)
	public final ResponseEntity<Object> handleException(feign.RetryableException ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), " Server is down, Please Retry after Sometime",
				request.getDescription(false));

		return new ResponseEntity<>(e,HttpStatus.SERVICE_UNAVAILABLE);

	}
	
	@ExceptionHandler(FeignException.InternalServerError.class)
	public final ResponseEntity<Object> handleException(FeignException.InternalServerError ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(), " Server is down, Please Retry after Sometime",
				request.getDescription(false));

		return new ResponseEntity<>(e, HttpStatus.valueOf(ex.status()));

	}
	
}
