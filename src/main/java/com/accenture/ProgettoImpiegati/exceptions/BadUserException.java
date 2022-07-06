package com.accenture.ProgettoImpiegati.exceptions;

public class BadUserException extends RuntimeException{

	public BadUserException() {
		super();
	}
	
	public BadUserException(String message) {
		super(message);
	}
	
	
}
