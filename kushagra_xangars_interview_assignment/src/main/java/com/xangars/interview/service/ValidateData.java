package com.xangars.interview.service;


import com.xangars.interview.model.ValidationRequestResponse;

public interface ValidateData {
	ValidationRequestResponse validateMobileNumber(long mobileNumber, String dobString);
	ValidationRequestResponse validateEmailAndDob(String eMail,String dobString );
}
