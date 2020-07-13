package com.tata.aia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tata.aia.model.OptInLogger;

@Repository
public interface OptInLoggerRepository extends JpaRepository<OptInLogger, Long> {
	List<OptInLogger> findByMobileNumber(long mobileNumber);
}
