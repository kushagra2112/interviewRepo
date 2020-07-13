package com.tata.aia.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tata.aia.exceptions.DobTypeException;
import com.tata.aia.exceptions.MobileNumberNotFoundException;
import com.tata.aia.exceptions.PolicyNumberException;
import com.tata.aia.exceptions.TokenNotValidException;
import com.tata.aia.model.ExceptionErrorMsg;


@Service
@ControllerAdvice
public class ExceptionalHandlerImplementation {
	
	public ExceptionalHandlerImplementation() {
		
	}

	@Autowired
	@ExceptionHandler
	@Qualifier("MobileNumberNotFoundException")
	public ResponseEntity<ExceptionErrorMsg> handleException(MobileNumberNotFoundException exc){
		
		ExceptionErrorMsg error = new ExceptionErrorMsg();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@Autowired
	@ExceptionHandler
	@Qualifier("TokenNotValidException")
	public ResponseEntity<ExceptionErrorMsg> handleException(TokenNotValidException exc){
		
		ExceptionErrorMsg error = new ExceptionErrorMsg();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@Autowired
	@ExceptionHandler
	@Qualifier("PolicyNumberException")
	public ResponseEntity<ExceptionErrorMsg> handleException(PolicyNumberException exc){
		
		ExceptionErrorMsg error = new ExceptionErrorMsg();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@Autowired
	@ExceptionHandler
	@Qualifier("DobTypeException")
	public ResponseEntity<ExceptionErrorMsg> handleException(DobTypeException exc){
		
		ExceptionErrorMsg error = new ExceptionErrorMsg();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	/*@Autowired
	@ExceptionHandler
	@Qualifier("MobileNumberNotFoundException")
	public ResponseEntity<ExceptionErrorMsg> handleException(Exception exc) {
		
		// create a StudentErrorResponse
		ExceptionErrorMsg error = new ExceptionErrorMsg();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}*/

}
