package com.scms.credit_report_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scms.credit_report_service.dto.UserDTO;

@FeignClient("user-service")
public interface UserClient {
	
	@GetMapping("/user/get-user-by-id/{id}")
	public UserDTO getUser(@PathVariable ("id")  Long id);

}
