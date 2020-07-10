package com.tata.aia.service;

import java.util.List;

import com.tata.aia.model.Policy;

public interface PolicyService {

	boolean updateEmail(String email, long policy_no, String token);

	List<Policy> updateEmail();
}
