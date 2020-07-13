package com.tata.aia.service;


import com.tata.aia.model.ValidationRequestResponse;

public interface ValidateData {
	ValidationRequestResponse validateMobileNumber(long mobileNumber, String dobString);
	ValidationRequestResponse validateEmailAndDob(String eMail,String dobString );
}
