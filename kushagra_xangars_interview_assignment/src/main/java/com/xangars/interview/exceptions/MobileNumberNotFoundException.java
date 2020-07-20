package com.xangars.interview.exceptions;

import org.springframework.stereotype.Service;

@Service
public class MobileNumberNotFoundException extends RuntimeException{

	public MobileNumberNotFoundException() {
	}
	
	
	public MobileNumberNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MobileNumberNotFoundException(String message) {
		super(message);
	}

	public MobileNumberNotFoundException(Throwable cause) {
		super(cause);
	}

}
