package com.scms.credit_report_service.dto;

public class UserDTO {
	private Long id;
	private String name;
	private String nrcNumber;
	private String emailId;
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrcNumber() {
		return nrcNumber;
	}
	public void setNrcNumber(String nrcNumber) {
		this.nrcNumber = nrcNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
