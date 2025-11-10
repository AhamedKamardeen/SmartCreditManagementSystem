package com.scms.credit_report_service.service;

import org.springframework.stereotype.Service;

import com.scms.credit_report_service.entity.CreditReport;

public interface CreditReportService {

	CreditReport getCreditReport(Long id);

}
