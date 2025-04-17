package com.ems.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	
		System.out.println("X");
		 return ex.getMessage();
	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	public String handleDuplicateEmployeeException(DuplicateEmployeeException ex) {


		return ex.getMessage();
	}

}
