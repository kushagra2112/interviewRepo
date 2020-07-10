package com.tata.aia.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tata.aia.model.Policy;
import com.tata.aia.service.PolicyService;

@RestController
@ResponseBody
@RequestMapping("/policy/")
public class PolicyController {
	
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private PolicyService policyService;
	
	@PutMapping(path = "update-email")
	public String updateEmail(@RequestParam String email, @RequestParam long policy_no, @RequestParam String token) {
		boolean success = policyService.updateEmail(email, policy_no, token);
		return success ? "Done" : "Error";
	}
	
	@GetMapping(path = "get-email")
	public List<Policy> getEmail() {
		List<Policy> updateEmail = policyService.updateEmail();
		logger.info(updateEmail);
		return updateEmail;
	}
}
