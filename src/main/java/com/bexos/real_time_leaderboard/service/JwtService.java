package com.bexos.real_time_leaderboard.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.lang.Function;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUsername(CharSequence token);
    <T> T extractClaim(CharSequence token, Function<Claims, T> claimsResolver);
    String generateToken(UserDetails userDetails);
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
}
