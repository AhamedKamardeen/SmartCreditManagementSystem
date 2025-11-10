package com.scms.credit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scms.credit_service.entity.CreditReport;
import com.scms.credit_service.service.CreditService;
import com.scms.user_service.dto.CreditUserDTO;

@RestController
@RequestMapping("/credit")
public class CreditController {
	
	@Autowired
	CreditService creditService;
	
	@PostMapping("/create-report/{userId}")
	public CreditReport createReport(@PathVariable ("userId") Long userId) {
		return creditService.createReport(userId);
	}
	
	@PostMapping("/create-user-report/{userId}")
	public CreditUserDTO createUserReport(@PathVariable ("userId") Long userId) {
		return creditService.createUserReport(userId);
	}
}
