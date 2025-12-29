package com.scms.credit_service.utility;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
        "scms-secret-key-for-jwt-token-256-bit-long";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        System.out.println("USERNAME FROM TOKEN = " + extractUsername(token));
        System.out.println("USERNAME FROM DB = " + userDetails.getUsername());
        System.out.println("TOKEN EXPIRED = " + isTokenExpired(token));

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }
}

