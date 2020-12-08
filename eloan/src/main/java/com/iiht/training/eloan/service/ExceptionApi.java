package com.iiht.training.eloan.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionApi {

	
	public static String toErrMsg(List<ObjectError> allErrors) {
		
		StringBuilder sb = new StringBuilder();
		for(ObjectError err:allErrors) {
			sb.append(err.getDefaultMessage() + ",");
		}
		return sb.toString();
	}
	
	
}
