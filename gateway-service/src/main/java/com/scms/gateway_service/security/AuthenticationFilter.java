package com.scms.gateway_service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.scms.gateway_service.utility.JwtUtil;

import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter
        extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            String authHeader = exchange.getRequest()
                    .getHeaders()
                    .getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authHeader.substring(7);

            try {
                // ✅ 1. CHECK TOKEN EXPIRY HERE
                if (jwtUtil.isTokenExpired(token)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                // ✅ 2. EXTRACT USER DETAILS
                String username = jwtUtil.extractUsername(token);

                // (temporary – later you can extract from JWT)
                String role = "ROLE_USER";

                // ✅ 3. ADD HEADERS FOR DOWNSTREAM SERVICES
                ServerHttpRequest modifiedRequest =
                        exchange.getRequest().mutate()
                                .header("X-User-Name", username)
                                .header("X-User-Role", role)
                                .build();

                return chain.filter(
                        exchange.mutate().request(modifiedRequest).build()
                );

            } catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }


    public static class Config {
    }
}