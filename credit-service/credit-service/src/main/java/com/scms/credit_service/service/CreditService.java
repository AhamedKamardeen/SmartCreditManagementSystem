package com.scms.credit_service.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.scms.credit_service.entity.CreditReport;
import com.scms.user_service.dto.CreditUserDTO;

@Service
public interface CreditService {

	Map createReport(Long userId);

	CreditUserDTO createUserReport(Long userId);

}
