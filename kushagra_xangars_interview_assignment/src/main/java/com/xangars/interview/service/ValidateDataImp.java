package com.xangars.interview.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xangars.interview.exceptions.DobTypeException;
import com.xangars.interview.exceptions.PolicyNumberException;
import com.xangars.interview.model.ValidationRequestResponse;
import com.xangars.interview.repository.PolicyRepository;

@Service
public class ValidateDataImp implements ValidateData {
	
	
	private static final Logger logger = LogManager.getLogger(); 
	
	@Autowired
	private PolicyRepository policyRepository; 

	@Override
	public ValidationRequestResponse validateMobileNumber(long mobileNumber, String dobString) {

		logger.info("validateMobileNumber called");
		Date dob = new Date();
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
		} catch (ParseException e1) {
			throw new DobTypeException("DON format exception use (YYYY-MM-DD) format");
		}

		int count = 0;
		try {
			count = policyRepository.findByMobileNumberAndDob(mobileNumber, dob).size();
			if (count == 0) {
				throw new PolicyNumberException(
						"No entry present with mobile number : " + mobileNumber + " and DOB : " + dob);
			}
		} catch (Exception e) {
			throw new PolicyNumberException("Something went wrong while validating the details");
		}
		logger.info("validateMobileNumber called");

		return new ValidationRequestResponse("1005", mobileNumber + "");
	}

	@Override
	public ValidationRequestResponse validateEmailAndDob(String eMail,String dobString) {
		logger.info("validateMobileNumber called");		
		Date dob =  new Date();
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString.toString());
		} catch (ParseException e1) {
			throw new DobTypeException("DON format exception use (YYYY-MM-DD) format");
		}  
		
		int count = 0 ;
		try {
			count = policyRepository.findByEmailAddressAndDob(eMail, dob).size();
			if(count == 0) {
				throw new PolicyNumberException("No entry present with eMail Address : " + eMail+ " and DOB : " + dob);
			}			
		}catch(Exception e){
			throw new PolicyNumberException("Something went wrong while validating the details");
		}
		logger.info("validateMobileNumber loded");
		return new ValidationRequestResponse("1005", eMail);
	}

}
