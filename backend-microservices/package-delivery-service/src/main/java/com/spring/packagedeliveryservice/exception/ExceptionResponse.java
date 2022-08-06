package com.spring.packagedeliveryservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	
	private Date timeStamp;
	private String message;
	private String details;
	

}
