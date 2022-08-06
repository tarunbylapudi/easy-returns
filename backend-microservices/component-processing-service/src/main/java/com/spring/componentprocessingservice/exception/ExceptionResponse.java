package com.spring.componentprocessingservice.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss", timezone="Asia/Kolkata")
	private Date timeStamp;
	private String message;
	private String details;

}
