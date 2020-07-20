package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class PolicyServiceDetails {
	private String status;
	private CustomerPolicy data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerPolicy getData() {
		return data;
	}
	public void setData(CustomerPolicy data) {
		this.data = data;
	}
	
	

}
