package com.xangars.interview.service;

import com.xangars.interview.model.SecurityTokenResponse;

public interface SecurityToken {
	SecurityTokenResponse getSecurityToken(long mobileNumber , int otp);
}
