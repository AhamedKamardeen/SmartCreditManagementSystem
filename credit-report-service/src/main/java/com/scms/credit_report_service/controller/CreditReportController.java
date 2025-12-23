package com.scms.credit_report_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scms.credit_report_service.entity.CreditReport;
import com.scms.credit_report_service.service.CreditReportService;

@RestController
@RequestMapping("/credit-report")
public class CreditReportController {
	
	@Autowired
	CreditReportService creditReportService;
	
	@GetMapping("/get-report/{id}")
	public CreditReport getCreditReport(@PathVariable ("id") Long id) {
		return creditReportService.getCreditReport(id);
		
	}
	
	
}
