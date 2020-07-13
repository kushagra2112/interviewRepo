package com.tata.aia.service;

import com.tata.aia.model.StepComplitionResponse;

public interface MobileOtpInStepOneService {
	StepComplitionResponse processStepOne(long mobileNumber);
	StepComplitionResponse processStepTwo(long mobileNumber, long otp);
}
