package com.scms.credit_report_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.scms.credit_report_service.feign")
public class CreditReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditReportServiceApplication.class, args);
	}

}
