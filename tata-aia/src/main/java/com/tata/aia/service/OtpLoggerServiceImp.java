package com.tata.aia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tata.aia.model.OtpLogger;
import com.tata.aia.repository.OtpLoggerRepository;

@Service
public class OtpLoggerServiceImp  implements OtpLoggerService , UserDetailsService{
	@Autowired
    private OtpLoggerRepository otpLogger;

    @Override
    public UserDetails loadUserByUsername(long mobileNumber) throws UsernameNotFoundException {
        OtpLogger mobileNumberDetails = otpLogger.findByMobileNumber(mobileNumber);
        return new org.springframework.security.core.userdetails.User(mobileNumberDetails.getMobileNumber()+"" , mobileNumberDetails.getOtp()+"", new ArrayList<>());
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OtpLogger mobileNumberDetails = otpLogger.findByMobileNumber(Long.parseLong(username));
        return new org.springframework.security.core.userdetails.User(mobileNumberDetails.getMobileNumber()+"" , mobileNumberDetails.getOtp()+"", new ArrayList<>());
	}
}
