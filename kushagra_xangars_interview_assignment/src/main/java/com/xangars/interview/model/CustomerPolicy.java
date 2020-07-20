package com.xangars.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customerpolicy")
public class CustomerPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Policy_Number")
	private Long policyNumber;

	@Column(name = "Customer_ID")
	private String customerID;

	@Column(name = "Customer_Name")
	private String customerName;

	@Column(name = "Insured_Name")
	private String insuredName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "Email_Address")
	private String emailAddress;

	@Column(name = "Mobile_Number")
	private long mobileNumber;

	@Column(name = "Premium_Mode")
	private String premiumMode;

	@Column(name = "Policy_Status")
	private String policyStatus;

	@Column(name = "Customer_PAN_NO")
	private String customerPANNO;

	@Column(name = "Policy_Issuance_Date")
	private Date policyIssuanceDate;

	@Column(name = "Contact_Number_Last_updated")
	private Date contactNumberLastUpdated;

	@Column(name = "Email_Address_Last_updated")
	private Date emailAddressLastUpdated;

	@Column(name = "Bank_Account_Number")
	private String bankAccountNumber;

	@Column(name = "whatsapp_opt_in_status")
	private String whatsappOptInStatus;

	@Column(name = "Product_Name")
	private String productName;

	@Column(name = "Product_ID")
	private String productID;

	@Column(name = "Reinvest_Applicable")
	private Boolean reinvestApplicable;

	@Column(name = "Outstanding_Payout")
	private int outstandingPayout;

	@Column(name = "Unclaimed_Amount")
	private int unclaimedAmount;

	@Column(name = "NEFT_Registered")
	private boolean neftRegistered;

	@Column(name = "Last_Premium_Paid")
	private Date lastPremiumPaid;

	public Long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getCustomerPANNO() {
		return customerPANNO;
	}

	public void setCustomerPANNO(String customerPANNO) {
		this.customerPANNO = customerPANNO;
	}

	public Date getPolicyIssuanceDate() {
		return policyIssuanceDate;
	}

	public void setPolicyIssuanceDate(Date policyIssuanceDate) {
		this.policyIssuanceDate = policyIssuanceDate;
	}

	public Date getContactNumberLastUpdated() {
		return contactNumberLastUpdated;
	}

	public void setContactNumberLastUpdated(Date contactNumberLastUpdated) {
		this.contactNumberLastUpdated = contactNumberLastUpdated;
	}

	public Date getEmailAddressLastUpdated() {
		return emailAddressLastUpdated;
	}

	public void setEmailAddressLastUpdated(Date emailAddressLastUpdated) {
		this.emailAddressLastUpdated = emailAddressLastUpdated;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getWhatsappOptInStatus() {
		return whatsappOptInStatus;
	}

	public void setWhatsappOptInStatus(String whatsappOptInStatus) {
		this.whatsappOptInStatus = whatsappOptInStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Boolean getReinvestApplicable() {
		return reinvestApplicable;
	}

	public void setReinvestApplicable(Boolean reinvestApplicable) {
		this.reinvestApplicable = reinvestApplicable;
	}

	public int getOutstandingPayout() {
		return outstandingPayout;
	}

	public void setOutstandingPayout(int outstandingPayout) {
		this.outstandingPayout = outstandingPayout;
	}

	public int getUnclaimedAmount() {
		return unclaimedAmount;
	}

	public void setUnclaimedAmount(int unclaimedAmount) {
		this.unclaimedAmount = unclaimedAmount;
	}

	public boolean isNeftRegistered() {
		return neftRegistered;
	}

	public void setNeftRegistered(boolean neftRegistered) {
		this.neftRegistered = neftRegistered;
	}

	public Date getLastPremiumPaid() {
		return lastPremiumPaid;
	}

	public void setLastPremiumPaid(Date lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", customerID=" + customerID + ", customerName=" + customerName
				+ ", insuredName=" + insuredName + ", dob=" + dob + ", emailAddress=" + emailAddress + ", mobileNumber="
				+ mobileNumber + ", premiumMode=" + premiumMode + ", policyStatus=" + policyStatus + ", customerPANNO="
				+ customerPANNO + ", policyIssuanceDate=" + policyIssuanceDate + ", contactNumberLastUpdated="
				+ contactNumberLastUpdated + ", emailAddressLastUpdated=" + emailAddressLastUpdated
				+ ", bankAccountNumber=" + bankAccountNumber + ", whatsappOptInStatus=" + whatsappOptInStatus
				+ ", productName=" + productName + ", productID=" + productID + ", reinvestApplicable="
				+ reinvestApplicable + ", outstandingPayout=" + outstandingPayout + ", unclaimedAmount="
				+ unclaimedAmount + ", neftRegistered=" + neftRegistered + ", lastPremiumPaid=" + lastPremiumPaid + "]";
	}
}
