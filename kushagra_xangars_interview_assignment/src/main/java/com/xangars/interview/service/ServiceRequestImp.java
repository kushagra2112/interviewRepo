package com.xangars.interview.service;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xangars.interview.exceptions.PolicyNumberException;
import com.xangars.interview.model.CustomerPolicy;
import com.xangars.interview.model.ServiceRequest;
import com.xangars.interview.model.ServiceRequestResponse;
import com.xangars.interview.repository.PolicyRepository;
import com.xangars.interview.repository.ServiceRequestRepository;

@Service
@Component
public class ServiceRequestImp implements ServiceRequestData {
	private static final Logger logger = LogManager.getLogger(); 
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	
	@Autowired
	private PolicyRepository policyRepository; 
	
	
	@Override
	public ServiceRequestResponse updateMobileNumber(long mobileNumber, long policyNumber) {
		validateByPolicyNumber(policyNumber);
		try {
			CustomerPolicy customerPolicy = policyRepository.findById(policyNumber).get();
			customerPolicy.setMobileNumber(mobileNumber);
			policyRepository.saveAndFlush(customerPolicy);
			logger.info("Mobile Number updated sucessfully");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		ServiceRequest serviceRequest = new ServiceRequest();
		
		serviceRequest.setMobileNumber(mobileNumber);
		serviceRequest.setPolicyNumber(policyNumber);
		serviceRequest.setOptinDate(new Date());
		serviceRequest.setRequestDetails("Mobile Number Updated");
		
		return responseData(serviceRequest , 
				"Service Request for Mobile Number Updation Generated");
	}


	@Override
	public ServiceRequestResponse updateEmailAddress(String emailAddress, long policyNumber) {
		validateByPolicyNumber(policyNumber);
		try {
			CustomerPolicy customerPolicy = policyRepository.findById(policyNumber).get();
			customerPolicy.setEmailAddress(emailAddress);
			policyRepository.saveAndFlush(customerPolicy);
			logger.info("Email updated sucessfully");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}

		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setPolicyNumber(policyNumber);
		serviceRequest.setOptinDate(new Date());
		serviceRequest.setRequestDetails("Email Address Updated to " + emailAddress);
		
		return responseData(serviceRequest, "Service Request for Emai Address Updation Generated");
	}


	@Override
	public ServiceRequestResponse updatePanCardNumber(String panCardNumber, long policyNumber) {
		validateByPolicyNumber(policyNumber);
		try {
			CustomerPolicy customerPolicy = policyRepository.findById(policyNumber).get();
			customerPolicy.setCustomerPANNO(panCardNumber);
			policyRepository.saveAndFlush(customerPolicy);
			logger.info("Pan Card Number updated sucessfully");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}

		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setPolicyNumber(policyNumber);
		serviceRequest.setOptinDate(new Date());
		serviceRequest.setRequestDetails("Pan Card Number Updated");
		
		return responseData(serviceRequest, "Service Request for PAN Card Updation Generated");
	}
	
	
	public ServiceRequestResponse responseData(ServiceRequest serviceRequest, String responseText) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		try {
			serviceRequest = serviceRequestRepository.save(serviceRequest);
			response.setStatus("1004");
			response.setData("SR" + serviceRequest.getEntityId());
			response.setMessage(responseText);
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}
	
	public void validateByPolicyNumber(long policyNumber) {
		CustomerPolicy customerPolicy;
		try {
			customerPolicy = policyRepository.findById(policyNumber).get();
			if (customerPolicy == null || customerPolicy.getPolicyNumber() == null) {
				throw new PolicyNumberException("Policy number not found");
			}
		} catch (Exception e) {
			throw new PolicyNumberException("Policy number not found");
		}
	}
	
	
}
