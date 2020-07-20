package com.xangars.interview.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xangars.interview.model.PolicyServiceDetails;
import com.xangars.interview.repository.PolicyRepository;

@Service
@Component
public class PolicyServiceImpl implements PolicyService {

	private static final Logger logger = LogManager.getLogger(); 

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public PolicyServiceDetails getDetailsByPolicy(long policyNumber) {
		PolicyServiceDetails policyServiceDetails = new PolicyServiceDetails();
		try {
			policyServiceDetails.setData(policyRepository.findById(policyNumber).get());
			policyServiceDetails.setStatus("1004");
		}catch(Exception e) {
			throw e;
		}
		return policyServiceDetails;
	}
}
