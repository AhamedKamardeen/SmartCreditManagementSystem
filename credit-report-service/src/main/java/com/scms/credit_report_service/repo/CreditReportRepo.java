package com.scms.credit_report_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scms.credit_report_service.entity.CreditReport;



@Repository
public interface CreditReportRepo extends JpaRepository<CreditReport, Long> {

}
