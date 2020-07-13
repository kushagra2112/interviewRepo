package com.tata.aia.service;



import com.tata.aia.model.ServiceRequestResponse;

public interface ServiceRequestData {
	ServiceRequestResponse updateMobileNumber(long mobileNumber, long policyNumber);
	ServiceRequestResponse updateEmailAddress(String emailAddress, long policyNumber);
	ServiceRequestResponse updatePanCardNumber(String panCardNumber, long policyNumber);
	
}
