package com.tata.aia.exceptions;

import org.springframework.stereotype.Service;

@Service
public class DobTypeException extends RuntimeException{
	
	public DobTypeException() {
		
	}

	public DobTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DobTypeException(String message) {
		super(message);
		
	}

	public DobTypeException(Throwable cause) {
		super(cause);
		
	}

}
