package com.codereveal.app.exceptions;

public class CustomException extends RuntimeException{
	
	private String message;
	
	public CustomException(String message) {
		this.message=message;
	}
	

	@Override
	public String getMessage() {
		return this.message;
	}

	
}
