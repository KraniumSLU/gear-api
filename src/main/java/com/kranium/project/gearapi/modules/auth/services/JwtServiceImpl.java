package com.kranium.project.gearapi.modules.auth.services;

import com.kranium.project.gearapi.modules.users.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@AllArgsConstructor
@Log4j2
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
    @Override
    public String generateToken(User user) {

        return Jwts.builder()
                .subject(user.getUuid().toString())
                .claim("role", user.getRole().name())
                .claim("name", user.getUsername())
                .issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+3600000))
                .signWith(getSignKey())
                .compact();
    }

    @Override
    public Claims validateToken(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}