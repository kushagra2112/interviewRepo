package com.tata.aia.exceptions;

import org.springframework.stereotype.Service;

@Service
public class PolicyNumberException extends RuntimeException {
	
	public PolicyNumberException() {
		
	}

	public PolicyNumberException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PolicyNumberException(String message) {
		super(message);
		
	}

	public PolicyNumberException(Throwable cause) {
		super(cause);
		
	}

}
