package com.accenture.ProgettoImpiegati.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
