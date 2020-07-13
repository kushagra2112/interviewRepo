package com.tata.aia.service;

import com.tata.aia.model.SecurityTokenResponse;

public interface SecurityToken {
	SecurityTokenResponse getSecurityToken(long mobileNumber , int otp);
}
