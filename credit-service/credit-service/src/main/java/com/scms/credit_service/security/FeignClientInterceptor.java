package com.scms.credit_service.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scms.credit_service.context.UserContext;

@Configuration
public class FeignClientInterceptor {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {

                String username = UserContext.getUsername();
                String role = UserContext.getRole();

                if (username != null) {
                    template.header("X-User-Name", username);
                }

                if (role != null) {
                    template.header("X-User-Role", role);
                }
            }
        };
    }
}
