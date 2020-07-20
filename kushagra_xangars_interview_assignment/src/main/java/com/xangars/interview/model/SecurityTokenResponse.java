package com.xangars.interview.model;

import org.springframework.stereotype.Service;

@Service
public class SecurityTokenResponse {
	
	String status;
	String token;
	String refresh;

	public SecurityTokenResponse() {
	}
	
	public SecurityTokenResponse(String status, String token, String refresh) {
		this.status = status;
		this.token = token;
		this.refresh = refresh;
	}
	
	//Generating Getters and Setters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefresh() {
		return refresh;
	}
	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
	
	//Overriding to String function
	@Override
	public String toString() {
		return "SecurityToken [status=" + status + ", token=" + token + ", refresh=" + refresh + "]";
	}
}
