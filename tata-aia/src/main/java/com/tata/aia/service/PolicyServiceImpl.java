package com.tata.aia.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tata.aia.model.Policy;
import com.tata.aia.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	private static final Logger logger = LogManager.getLogger(); 

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public boolean updateEmail(String email, long policy_no, String token) {

		logger.debug("Inside updateEmail");

		List<Policy> policies = policyRepository.findAll();
		logger.info("Policies : {}", policies);

		return false;
	}

	@Override
	public List<Policy> updateEmail() {
		logger.debug("Inside updateEmail");

		List<Policy> policies = policyRepository.findAll();
		logger.info("Policies : {}", policies);

		return policies;
	}
}
