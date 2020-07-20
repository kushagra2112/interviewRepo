package com.xangars.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otplogger")
public class OtpLogger {
	
	@Id
	@Column(name = "Mobile_Number")
	private long mobileNumber ;

	@Column(name = "OTP")
	private long otp ;

	@Column(name = "Expire_Time")
	private Date expireTime ;

	@Column(name = "Created_Time")
	private Date createdTime ;

	
	public OtpLogger() {
		this.createdTime = new Date(System.currentTimeMillis());
		this.expireTime = new Date(System.currentTimeMillis() + 3600*1000);
	}
	
	
	public OtpLogger(long mobileNumber, long otp) {
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.createdTime = new Date(System.currentTimeMillis());
		this.expireTime = new Date(System.currentTimeMillis() + 3600*1000);
	}


	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public Date getExpireTime() {
		return expireTime;
	}


	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}


	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	@Override
	public String toString() {
		return "table3 [mobileNumber=" + mobileNumber + ", otp=" + otp + ", expireTime=" + expireTime + ", createdTime="
				+ createdTime + "]";
	}

}
