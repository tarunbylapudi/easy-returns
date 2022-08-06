package com.spring.packagedeliveryservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	

	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidCountException.class)
	public final ResponseEntity<Object> handleException(InvalidCountException ex, WebRequest request){
		
		ExceptionResponse e=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ComponentTypeNotFoundException.class)
	public final ResponseEntity<Object> handleException(ComponentTypeNotFoundException ex, WebRequest request){
		
		ExceptionResponse e=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
	

}
