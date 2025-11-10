package com.scms.user_service.dto;

import com.scms.credit_service.entity.CreditReport;

public class CreditUserDTO {
	
	private UserDTO userDTO;
	private CreditReport creditReport;
	
	
	
	public CreditUserDTO(UserDTO userDTO, CreditReport creditReport) {
		super();
		this.userDTO = userDTO;
		this.creditReport = creditReport;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public CreditReport getCreditReport() {
		return creditReport;
	}
	public void setCreditReport(CreditReport creditReport) {
		this.creditReport = creditReport;
	}
	
	
	
	

}
