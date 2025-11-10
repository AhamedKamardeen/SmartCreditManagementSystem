package com.scms.credit_report_service.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scms.credit_report_service.dto.UserDTO;
import com.scms.credit_report_service.entity.CreditReport;
import com.scms.credit_report_service.feign.UserClient;
import com.scms.credit_report_service.repo.CreditReportRepo;
import com.scms.credit_report_service.service.CreditReportService;

@Service
public class CreditReportServiceImpl implements CreditReportService{
	
	@Autowired
	CreditReportRepo creditReportRepo;
	
	@Autowired
	UserClient userClient;

	@Override
	public CreditReport getCreditReport(Long id) {
		UserDTO userDTO = new UserDTO();
		CreditReport creditReport = new CreditReport(); 
		try {
			userDTO= userClient.getUser(id);
			
			 if (userDTO == null) {
		            throw new RuntimeException("User not found");
		        }
			 
			 creditReport.setUserId(userDTO.getId());
			 creditReport.setReportStatus("Generated");
			 creditReport.setRemarks("Reporr  Generated Successfully........................");
			 creditReport.setReportNumber(UUID.randomUUID().toString());
			 creditReport = creditReportRepo.save(creditReport);
			 
		      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return creditReport;
	}
	
	

}
