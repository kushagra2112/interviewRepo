package com.xangars.interview.service;


import com.xangars.interview.model.PolicyServiceDetails;

public interface PolicyService {
	PolicyServiceDetails getDetailsByPolicy(long policyNumber);
}
