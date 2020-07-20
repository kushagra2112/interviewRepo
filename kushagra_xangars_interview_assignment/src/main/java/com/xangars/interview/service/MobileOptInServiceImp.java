package com.xangars.interview.service;



import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xangars.interview.exceptions.MobileNumberNotFoundException;
import com.xangars.interview.model.CustomerPolicy;
import com.xangars.interview.model.OptInLogger;
import com.xangars.interview.model.StepComplitionResponse;
import com.xangars.interview.repository.OptInLoggerRepository;
import com.xangars.interview.repository.OtpLoggerRepository;
import com.xangars.interview.repository.PolicyRepository;

@Service
public class MobileOptInServiceImp implements MobileOptInService {

	private static final Logger logger = LogManager.getLogger();
	
	
	@Autowired
	OptInLoggerRepository optInLoggerRepository;
	
	@Autowired
	PolicyRepository policyRepository; 
	
	@Autowired
	OtpLoggerRepository otpLoggerRepository;
	
	
	@Override
	public StepComplitionResponse processStepOne(long mobileNumber) {
		int optInLoggerCount = optInLoggerRepository.findByMobileNumber(mobileNumber).size();
		
		if(optInLoggerCount > 0) {
			return new StepComplitionResponse("1001",  "Thank You for Optin Request Completed");
		}else if(policyRepository.findByMobileNumber(mobileNumber).size() > 0){
			return new StepComplitionResponse("1001",  "Optin OTP Sent on the Mobile Number");
		}else {
			throw new MobileNumberNotFoundException("Mobile number id not registered with any policy");
		}
	}

	@Override
	public StepComplitionResponse processStepTwo(long mobileNumber, long otp) {
		
		if(otpLoggerRepository.findByMobileNumberAndOtp(mobileNumber, otp) != null) {
			
			try {
				
				List<CustomerPolicy> customerPolicies = policyRepository.findByMobileNumber(mobileNumber);
				
				
				OptInLogger singleEntry = new OptInLogger(); 
				
				for(CustomerPolicy policy : customerPolicies) {
					singleEntry = new OptInLogger();
					singleEntry.setMobileNumber(policy.getMobileNumber());
					singleEntry.setPolicyNumber(policy.getPolicyNumber());
					singleEntry.setOptinDate(new Date());
					optInLoggerRepository.save(singleEntry);
					
				}
				
				logger.info("Opt In Step Two Completed Sucessfully");
				
			}catch(Exception e) {
				logger.debug(e.getMessage());
				throw e;
			}
		}
		
		return new StepComplitionResponse("1001",  "Thank You for Optin Request Completed");
	}

}
