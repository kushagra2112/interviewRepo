package com.xangars.interview.service;



import com.xangars.interview.model.ServiceRequestResponse;

public interface ServiceRequestData {
	ServiceRequestResponse updateMobileNumber(long mobileNumber, long policyNumber);
	ServiceRequestResponse updateEmailAddress(String emailAddress, long policyNumber);
	ServiceRequestResponse updatePanCardNumber(String panCardNumber, long policyNumber);
	
}
