package com.tata.aia.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface OtpLoggerService {
	UserDetails loadUserByUsername(long mobileNumber);
}
