package com.xangars.interview.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xangars.interview.model.CustomerPolicy;

@Repository
public interface PolicyRepository extends JpaRepository<CustomerPolicy, Long> {
	List<CustomerPolicy> findByCustomerName(String name);
	List<CustomerPolicy> findByMobileNumber(long number);
	List<CustomerPolicy> findByMobileNumberAndDob(long mobileNumber, Date dob);
	List<CustomerPolicy> findByEmailAddressAndDob(String email, Date dob);
}
