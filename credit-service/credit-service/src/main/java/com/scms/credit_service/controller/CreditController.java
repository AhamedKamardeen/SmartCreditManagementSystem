package com.scms.credit_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/test")
	public String test() {
		return "test successfully................";
	}
	
	@PostMapping("/create-report/{userId}")
	public Map createReport(@PathVariable ("userId") Long userId) {
		return creditService.createReport(userId);
	}
	
	@PostMapping("/create-user-report/{userId}")
	public CreditUserDTO createUserReport(@PathVariable ("userId") Long userId) {
		return creditService.createUserReport(userId);
	}
}
