package com.scms.credit_service.serviceimpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scms.credit_service.entity.CreditReport;
import com.scms.credit_service.feign.UserClient;
import com.scms.credit_service.repo.CreditRepo;
import com.scms.credit_service.service.CreditService;
import com.scms.user_service.dto.CreditUserDTO;
import com.scms.user_service.dto.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	UserClient userClient;

	@Autowired
	CreditRepo creditRepo;


	@CircuitBreaker(name="userServiceBreaker" , fallbackMethod = "userFallBack")
	@Override
	public Map createReport(Long userId) {
		Map response = new HashMap<>();
		CreditReport report = new CreditReport();
		
		
		
		

			UserDTO userDTO = userClient.getUser(userId);

			try {
			report.setUserId(userId);
			report.setCreditScore((int) (Math.random() * 400) + 400); // score between 400–800
			report.setCreditStatus(report.getCreditScore() > 650 ? "GOOD" : "POOR");
			report.setReportGeneratedDate(LocalDate.now().toString());

			report =  creditRepo.save(report);
			
			response.put("creditReport", report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	public Map userFallBack(Long userId , Throwable throwable) {

	    Map<String, Object> fallbackResponse = new HashMap<>();
	    fallbackResponse.put("message", "User service is down. Returning fallback response.");
	    fallbackResponse.put("userId", userId);
	    fallbackResponse.put("error", throwable.getMessage());

	    return fallbackResponse;
	}
	

	@Override
	public CreditUserDTO createUserReport(Long userId) {
		CreditReport report = new CreditReport();
		UserDTO userDTO = new UserDTO();

		try {
			 userDTO = userClient.getUser(userId);
			report.setUserId(userId);
			report.setCreditScore((int) (Math.random() * 400) + 400); // score between 400–800
			report.setCreditStatus(report.getCreditScore() > 650 ? "GOOD" : "POOR");
			report.setReportGeneratedDate(LocalDate.now().toString());

			report=  creditRepo.save(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CreditUserDTO(userDTO, report);
	}

}