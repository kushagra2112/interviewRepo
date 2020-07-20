package com.xangars.interview.service;

import com.xangars.interview.model.StepComplitionResponse;

public interface MobileOptInService {
	StepComplitionResponse processStepOne(long mobileNumber);
	StepComplitionResponse processStepTwo(long mobileNumber, long otp);
}
