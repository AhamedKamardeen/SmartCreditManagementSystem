package com.scms.credit_service.serviceimpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scms.credit_service.entity.CreditReport;
import com.scms.credit_service.feign.UserClient;
import com.scms.credit_service.repo.CreditRepo;
import com.scms.credit_service.service.CreditService;
import com.scms.user_service.dto.UserDTO;

@Service
public class CreditServiceImpl implements CreditService {
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	CreditRepo creditRepo;

	@Override
	public CreditReport createReport(Long userId) {
		CreditReport report = new CreditReport();
		
		try {
			UserDTO userDTO = userClient.getUser(userId);
		        report.setUserId(userId);
		        report.setCreditScore((int)(Math.random() * 400) + 400); // score between 400–800
		        report.setCreditStatus(report.getCreditScore() > 650 ? "GOOD" : "POOR");
		        report.setReportGeneratedDate(LocalDate.now().toString());

		        return creditRepo.save(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	
	

}
