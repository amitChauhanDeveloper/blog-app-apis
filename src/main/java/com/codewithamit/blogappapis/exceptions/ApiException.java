package com.codewithamit.blogappapis.exceptions;

public class ApiException extends RuntimeException {
	
	public ApiException(String message) {
		super(message);
	}


    public ApiException() {
		super();	
	}
}
