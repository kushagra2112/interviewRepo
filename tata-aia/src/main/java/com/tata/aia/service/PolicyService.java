package com.tata.aia.service;


import com.tata.aia.model.PolicyServiceDetails;

public interface PolicyService {
	PolicyServiceDetails getDetailsByPolicy(long policyNumber);
}
