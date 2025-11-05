package com.scms.credit_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scms.credit_service.entity.CreditReport;

public interface CreditRepo extends JpaRepository<CreditReport, Long> {

}
