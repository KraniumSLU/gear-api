package com.kranium.project.gearapi.modules.tokens.service;

import com.kranium.project.gearapi.modules.users.domain.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtService {
    String generateToken(User user);
    Claims validateToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpiration(String token);
    String extractUsername(String token);
    String extractUuid(String token);
    String extractRole(String token);
    String extractSubject(String token);
}
