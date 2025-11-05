package com.scms.credit_service.service;

import org.springframework.stereotype.Service;

import com.scms.credit_service.entity.CreditReport;

@Service
public interface CreditService {

	CreditReport createReport(Long userId);

}
