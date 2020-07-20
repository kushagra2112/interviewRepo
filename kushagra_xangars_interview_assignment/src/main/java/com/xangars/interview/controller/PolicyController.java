package com.xangars.interview.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xangars.interview.exceptions.MobileNumberNotFoundException;
import com.xangars.interview.exceptions.TokenNotValidException;
import com.xangars.interview.model.CustomerPolicy;
import com.xangars.interview.model.PolicyServiceDetails;
import com.xangars.interview.model.SecurityTokenResponse;
import com.xangars.interview.model.ServiceRequestResponse;
import com.xangars.interview.model.StepComplitionResponse;
import com.xangars.interview.model.ValidationRequestResponse;
import com.xangars.interview.repository.PolicyRepository;
import com.xangars.interview.service.JwtUtil;
import com.xangars.interview.service.MobileOptInService;
import com.xangars.interview.service.PolicyService;
import com.xangars.interview.service.SecurityToken;
import com.xangars.interview.service.ServiceRequestData;
import com.xangars.interview.service.ValidateDataImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;

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
	private MobileOptInService mobileOtpInStepOneService;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private ValidateDataImp validateDataImp;

	@Autowired
	JwtUtil jwtTokenObject;

	@PostMapping(path = "/authenticate")
	@ApiOperation(value = "Generate Security Token",
	notes = "This function is used to generate token for the user",
	response = Contact.class)
	public ResponseEntity<SecurityTokenResponse> getToken(
			@ApiParam(value = "Mobile Number") @RequestParam long mobileNumber,
			@ApiParam(value = "OTP") @RequestParam int otp) {
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
	@ApiOperation(value = "Get Policy Details",
	notes = "Returns Complete Policy Details, return an error response is policy is not present or invalid",
	response = Contact.class)
	public ResponseEntity<PolicyServiceDetails> getPolicyDetailsByPhoneNumber(
			@ApiParam(value = "Policy Number") @RequestParam long policyNumber,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Validate's your email address",
	notes = "Return your validated email if both email and dob matched to your policies",
	response = Contact.class)
	public ResponseEntity<ValidationRequestResponse> validateEmailAddress(
			@ApiParam(value = "eMail Arrdess") @RequestParam String eMail,
			@ApiParam(value = "Date Of Birth Sample Format (YYYY-MM-DD)") @RequestParam String dob,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Validate's your mobile number",
	notes = "Return your validated mobile number if both mobile number and dob matched to any of your policies",
	response = Contact.class)
	public ResponseEntity<ValidationRequestResponse> validateMobileNumberRequest(
			@ApiParam(value = "Mobile Number") @RequestParam long mobileNumber,
			@ApiParam(value = "Date Of Birth Sample Format (YYYY-MM-DD)")@RequestParam String dob,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Update yor mobile number",
	notes = "Returns you a service ticket if alteast one record matches with you policy number",
	response = Contact.class)
	public ResponseEntity<ServiceRequestResponse> updateMobileNumberRequest(
			@ApiParam(value = "Mobile Number") @RequestParam long mobileNumber,
			@ApiParam(value = "Reference Policy Number") @RequestParam long policyNumber,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Update yor email address",
	notes = "Returns you a service ticket if alteast one record matches with you policy number",
	response = Contact.class)
	public ResponseEntity<ServiceRequestResponse> updateEmail(
			@ApiParam(value = "EMail Address") @RequestParam String email,
			@ApiParam(value = "Policy Number") @RequestParam long policyNumber,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Update yor PAN card number",
	notes = "Returns you a service ticket if alteast one record matches with you policy number",
	response = Contact.class)
	public ResponseEntity<ServiceRequestResponse> updatePanCard(
			@ApiParam(value = "New PanCard Number")@RequestParam String panCard,
			@ApiParam(value = "Refrence Policy Number") @RequestParam long policyNumber,
			@ApiParam(value = "JWT token generated previously") @RequestParam String jwtToken) {
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
	@ApiOperation(value = "Step 1 for to opt in for mobile service",
	notes = "Return \"Thank You for Optin Request Completed\" if you are new to this service \n or return's \"Optin OTP Sent on the Mobile Number\" if you are already using one ",
	response = Contact.class)
	public ResponseEntity<StepComplitionResponse> MobileOtpInStepOne(
			@ApiParam(value = "Mobile Number") @RequestParam long mobileNumber) {
		logger.info("Serving request for mobile opt in step one");
		return new ResponseEntity<>(mobileOtpInStepOneService.processStepOne(mobileNumber), HttpStatus.OK);
	}

	@PostMapping(path = "/optForMobileOtpStepTwo")
	@ApiOperation(value = "Completing mobile service validation",
	notes = "Returns \"Thank You for Optin Request Completed\" \n if you have opted for mobile service already \n else throes an error response",
	response = Contact.class)
	public ResponseEntity<StepComplitionResponse> MobileOtpInStepTwo(
			@ApiParam(value = "Mobile Number") @RequestParam long mobileNumber,
			@ApiParam(value = "OTP") @RequestParam long otp) {
		logger.info("Serving request for mobile opt in step two");
		return new ResponseEntity<>(mobileOtpInStepOneService.processStepTwo(mobileNumber, otp), HttpStatus.OK);
	}

}
