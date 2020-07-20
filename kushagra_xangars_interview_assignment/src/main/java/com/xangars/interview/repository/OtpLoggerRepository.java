package com.xangars.interview.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xangars.interview.model.OtpLogger;

@Repository
public interface OtpLoggerRepository extends JpaRepository<OtpLogger, Long> {
	OtpLogger findByMobileNumber(long mobileNumber);
	OtpLogger findByMobileNumberAndOtp(long mobileNumber, long otp);
}
