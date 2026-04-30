package com.kranium.project.gearapi.modules.tokens.service;

import com.kranium.project.gearapi.modules.users.domain.User;
import io.jsonwebtoken.Claims;

public interface JwtService {
    String generateToken(User user);
    Claims validateToken(String token);
    boolean isTokenValid(String token);
    String extractUsername(String token);
    String extractSubject(String token);
}
