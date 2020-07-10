package com.tata.aia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tata.aia.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
	List<Policy> findByCustomerName(String name);
}
