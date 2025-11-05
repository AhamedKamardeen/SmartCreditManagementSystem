package com.scms.credit_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreditReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private int creditScore;
	private String creditStatus;
	private String reportGeneratedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getReportGeneratedDate() {
		return reportGeneratedDate;
	}

	public void setReportGeneratedDate(String reportGeneratedDate) {
		this.reportGeneratedDate = reportGeneratedDate;
	}

	@Override
	public String toString() {
		return "CreditReport [id=" + id + ", userId=" + userId + ", creditScore=" + creditScore + ", creditStatus="
				+ creditStatus + ", reportGeneratedDate=" + reportGeneratedDate + "]";
	}
	
	

}
