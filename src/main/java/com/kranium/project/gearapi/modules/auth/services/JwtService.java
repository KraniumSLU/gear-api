package com.kranium.project.gearapi.modules.auth.services;

import com.kranium.project.gearapi.modules.users.domain.User;
import io.jsonwebtoken.Claims;

public interface JwtService {
    String generateToken(User user);
    Claims validateToken(String token);
}
