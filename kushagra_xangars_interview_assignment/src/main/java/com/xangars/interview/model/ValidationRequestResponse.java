package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class ValidationRequestResponse {
	private String Status;
	private String Data;
	
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
	
	public ValidationRequestResponse() {
		
	}
	public ValidationRequestResponse(String status, String data) {
		Status = status;
		Data = data;
	}
	
	
}
