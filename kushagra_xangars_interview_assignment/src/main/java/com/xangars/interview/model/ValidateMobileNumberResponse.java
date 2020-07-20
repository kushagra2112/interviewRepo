package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class ValidateMobileNumberResponse {
	private String Status;
	private String mobileNumber;
	
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	@Override
	public String toString() {
		return "ValidateMobileNumberResponse [Status=" + Status + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
