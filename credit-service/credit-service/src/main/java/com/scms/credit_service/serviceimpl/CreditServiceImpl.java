package com.scms.credit_service.serviceimpl;

import java.time.LocalDate;
import java.util.UUID;

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
	 
	@Override
	@CircuitBreaker(name="credCB" , fallbackMethod = "creditServiceFallback")
	public CreditReport createReport(Long userId) {
		CreditReport report = new CreditReport();
		UserDTO userDTO = userClient.getUser(userId);
		try {
			
			report.setUserId(userId);
			report.setCreditScore((int) (Math.random() * 400) + 400); // score between 400–800
			report.setCreditStatus(report.getCreditScore() > 650 ? "Vanthiruchu GOOD" : "Vanthiruchu POOR");
			report.setReportGeneratedDate(LocalDate.now().toString());

			return creditRepo.save(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
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
	
    public CreditReport creditServiceFallback(Long userId, Throwable ex) {
        CreditReport report = new CreditReport();
        report.setUserId(userId);
        report.setCreditScore(-1);
        report.setCreditStatus("varala varala");
//        report.setReportId("TEMP-" + UUID.randomUUID());
        return report;
    }

}
