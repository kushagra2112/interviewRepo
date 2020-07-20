package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class StepComplitionResponse {
	
	String Status;
	String Message;
	
	public StepComplitionResponse() {
		
	}
	
	public StepComplitionResponse(String status, String message) {
		Status = status;
		Message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "StepComplitionResponse [Status=" + Status + ", Message=" + Message + "]";
	};
	
	
	
}
