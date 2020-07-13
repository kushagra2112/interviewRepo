package com.tata.aia.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tata.aia.model.OtpLogger;
import com.tata.aia.model.SecurityTokenResponse;

import com.tata.aia.repository.OtpLoggerRepository;
import com.tata.aia.service.JwtUtil;

@Service
public class SecurityTokenImp implements SecurityToken {
	private static final Logger logger = LogManager.getLogger(); 

	
	@Autowired
	private OtpLoggerRepository otpLoggerRepository ;
	
	@Autowired
	private SecurityTokenResponse tokenResponse;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	
	@Override
	public SecurityTokenResponse getSecurityToken(long mobileNumber , int otp) {
		
		try {
			OtpLogger logInDetails =  new OtpLogger(mobileNumber, otp);
			otpLoggerRepository.saveAndFlush(logInDetails);
			tokenResponse.setStatus("1004");
			tokenResponse.setToken(jwtUtil.generateToken(logInDetails));
		}catch(Exception e) {
			throw e;
		}
		
		return tokenResponse;
	}

}
