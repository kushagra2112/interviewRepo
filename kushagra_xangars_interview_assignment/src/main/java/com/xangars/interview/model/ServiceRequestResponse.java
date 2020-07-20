package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class ServiceRequestResponse {
	
	private String Status;
	private String Data;
	private String Message;
	
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
