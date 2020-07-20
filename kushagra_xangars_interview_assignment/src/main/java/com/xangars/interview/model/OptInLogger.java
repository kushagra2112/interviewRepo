package com.xangars.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "optinlogger")
public class OptInLogger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Optin_ID")
	private long optinID ;

	@Column(name = "Mobile_Number")
	private long mobileNumber ;

	@Column(name = "Policy_Number")
	private long policyNumber ;

	@Column(name = "Optin_Date")
	private Date optinDate ;
	
	
	public long getOptinID() {
		return optinID;
	}

	public void setOptinID(long optinID) {
		this.optinID = optinID;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getOptinDate() {
		return optinDate;
	}

	public void setOptinDate(Date optinDate) {
		this.optinDate = optinDate;
	}

	@Override
	public String toString() {
		return "table3 [optinID=" + optinID + ", mobileNumber=" + mobileNumber + ", policyNumber=" + policyNumber
				+ ", optinDate=" + optinDate + "]";
	}
	
	
}
