package com.tata.aia.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tata.aia.exceptions.MobileNumberNotFoundException;
import com.tata.aia.exceptions.TokenNotValidException;
import com.tata.aia.model.CustomerPolicy;
import com.tata.aia.model.PolicyServiceDetails;
import com.tata.aia.model.SecurityTokenResponse;
import com.tata.aia.model.ServiceRequestResponse;
import com.tata.aia.model.StepComplitionResponse;
import com.tata.aia.model.ValidationRequestResponse;
import com.tata.aia.repository.PolicyRepository;
import com.tata.aia.service.JwtUtil;
import com.tata.aia.service.MobileOtpInStepOneService;
import com.tata.aia.service.PolicyService;
import com.tata.aia.service.SecurityToken;
import com.tata.aia.service.ServiceRequestData;
import com.tata.aia.service.ValidateDataImp;

@RestController
@ResponseBody
@RequestMapping("/policy/")
public class PolicyController {

	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private PolicyService policyService;

	@Autowired
	private SecurityToken securityToken;

	@Autowired
	private ServiceRequestData serviceRequestData;

	@Autowired
	private MobileOtpInStepOneService mobileOtpInStepOneService;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private ValidateDataImp validateDataImp;

	@Autowired
	JwtUtil jwtTokenObject;

	@PostMapping(path = "/authenticate")
	public ResponseEntity<SecurityTokenResponse> getToken(@RequestParam long mobileNumber, @RequestParam int otp) {
		logger.info("Serving request for authentication");
		try {
			int entryCount = policyRepository.findByMobileNumber(mobileNumber).size();
			if (entryCount == 0) {
				throw new MobileNumberNotFoundException("Mobile number not found");
			}
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(securityToken.getSecurityToken(mobileNumber, otp), HttpStatus.OK);
	}

	@PostMapping(path = "/getPolicyDetails")
	public ResponseEntity<PolicyServiceDetails> getPolicyDetailsByPhoneNumber(@RequestParam long policyNumber,
			@RequestParam String jwtToken) {
		logger.info("Serving request for fetching policy details");

		// validating token

		long mobileNumber = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");

		return new ResponseEntity<>(policyService.getDetailsByPolicy(policyNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/validateEmail")
	public ResponseEntity<ValidationRequestResponse> validateEmailAddress(@RequestParam String eMail,
			@RequestParam String dob, @RequestParam String jwtToken) {
		logger.info("Serving request for validating email");

		// validating token

		long mobileNumber = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");
		return new ResponseEntity<>(validateDataImp.validateEmailAndDob(eMail, dob), HttpStatus.OK);
	}

	@PostMapping(path = "/validateMobileNumber")
	public ResponseEntity<ValidationRequestResponse> validateMobileNumberRequest(@RequestParam long mobileNumber,
			@RequestParam String dob, @RequestParam String jwtToken) {
		logger.info("Serving request for validating mobile number");

		// validating token

		long mobileNumber2 = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber2).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");
		return new ResponseEntity<>(validateDataImp.validateMobileNumber(mobileNumber, dob), HttpStatus.OK);
	}

	@PostMapping(path = "/updateMobileNumber")
	public ResponseEntity<ServiceRequestResponse> updateMobileNumberRequest(@RequestParam long mobileNumber,
			@RequestParam long policyNumber, @RequestParam String jwtToken) {
		logger.info("Serving request for update mobile number");

		// validating token

		long mobileNumber2 = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber2).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");

		return new ResponseEntity<>(serviceRequestData.updateMobileNumber(mobileNumber, policyNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/updateEmail")
	public ResponseEntity<ServiceRequestResponse> updateEmail(@RequestParam String email,
			@RequestParam long policyNumber, @RequestParam String jwtToken) {
		logger.info("Serving request for update email");

		// validating token

		long mobileNumber = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");

		return new ResponseEntity<>(serviceRequestData.updateEmailAddress(email, policyNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/updatePanCard")
	public ResponseEntity<ServiceRequestResponse> updatePanCard(@RequestParam String panCard,
			@RequestParam long policyNumber, @RequestParam String jwtToken) {
		logger.info("Serving request for update pan card details");

		// validating token

		long mobileNumber = Long.parseLong(jwtTokenObject.extractUsername(jwtToken, 1));
		CustomerPolicy customerDetails = policyRepository.findByMobileNumber(mobileNumber).get(0);
		if (jwtTokenObject.validateToken(jwtToken, customerDetails, 1)) {
			logger.debug("token validated");
		} else {
			throw new TokenNotValidException("Token is not valid");
		}

		logger.info("Token Validated Sucessfully");

		return new ResponseEntity<>(serviceRequestData.updatePanCardNumber(panCard, policyNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/optForMobileOtpStepOne")
	public ResponseEntity<StepComplitionResponse> MobileOtpInStepOne(@RequestParam long mobileNumber) {
		logger.info("Serving request for mobile opt in step one");
		return new ResponseEntity<>(mobileOtpInStepOneService.processStepOne(mobileNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/optForMobileOtpStepTwo")
	public ResponseEntity<StepComplitionResponse> MobileOtpInStepTwo(@RequestParam long mobileNumber,
			@RequestParam long otp) {
		logger.info("Serving request for mobile opt in step two");
		return new ResponseEntity<>(mobileOtpInStepOneService.processStepTwo(mobileNumber, otp), HttpStatus.OK);
	}

}
