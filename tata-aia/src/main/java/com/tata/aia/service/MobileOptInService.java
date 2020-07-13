package com.tata.aia.service;

import com.tata.aia.model.StepComplitionResponse;

public interface MobileOptInService {
	StepComplitionResponse processStepOne(long mobileNumber);
	StepComplitionResponse processStepTwo(long mobileNumber, long otp);
}
