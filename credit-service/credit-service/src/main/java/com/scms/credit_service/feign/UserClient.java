package com.scms.credit_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scms.credit_service.security.FeignClientConfig;
import com.scms.user_service.dto.UserDTO;

@FeignClient( name = "user-service" ,configuration = FeignClientConfig.class)
public interface UserClient {
	
	@GetMapping("/user/get-user-by-id/{id}")
	public UserDTO getUser(@PathVariable ("id")  Long id);

}
