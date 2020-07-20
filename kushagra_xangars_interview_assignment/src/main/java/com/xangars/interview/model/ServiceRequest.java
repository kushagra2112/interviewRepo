package com.xangars.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "servicerequest")
public class ServiceRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "entityId")
	private long entityId ;

	@Column(name = "Mobile_Number")
	private long mobileNumber ;

	@Column(name = "Policy_Number")
	private long policyNumber ;

	@Column(name = "Optin_Date")
	private Date optinDate ;
	
	@Column(name = "Request_Details")
	private String requestDetails ;

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
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

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	@Override
	public String toString() {
		return "ServiceRequest [entityId=" + entityId + ", mobileNumber=" + mobileNumber + ", policyNumber="
				+ policyNumber + ", optinDate=" + optinDate + ", requestDetails=" + requestDetails + "]";
	}
	

	
	
}
