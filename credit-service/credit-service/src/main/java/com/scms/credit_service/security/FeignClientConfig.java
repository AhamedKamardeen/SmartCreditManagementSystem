package com.scms.credit_service.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

	public RequestInterceptor feignInterceptor() {
	    return template -> {
	        ServletRequestAttributes attrs =
	                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

	        if (attrs != null) {
	            String authHeader = attrs.getRequest().getHeader("Authorization");
	            if (authHeader != null) {
	                template.header("Authorization", authHeader);
	            }
	        }
	    };
	}
}
