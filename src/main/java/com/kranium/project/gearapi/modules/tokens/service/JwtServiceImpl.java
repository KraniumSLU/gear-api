package com.kranium.project.gearapi.modules.tokens.service;

import com.kranium.project.gearapi.modules.users.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
@Log4j2
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey key;

    @PostConstruct
    public void init(){
        this.key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    @Override
    public String generateToken(User user) {
        Instant now = Instant.now();
        return Jwts.builder()
                .issuer("gear-api")
                .subject(user.getUuid().toString())
                .claim("role", user.getRole().name())
                .claim("username", user.getUsername())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(expiration)))
                .signWith(key)
                .compact();
    }

    @Override
    public Claims validateToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    @Override
    public boolean isTokenValid(String token, UserDetails userDetails){
        try {
            validateToken(token);
            String username = extractUsername(token);
            return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
        }catch (RuntimeException e){
            return false;
        }
    }

    @Override
    public boolean isTokenExpired(String token) {
        Date expiration = validateToken(token).getExpiration();

        return expiration.before(new Date());
    }

    @Override
    public Date extractExpiration(String token) {
        return validateToken(token).getExpiration();
    }

    @Override
    public String extractUsername(String token){
        return validateToken(token).getSubject();
    }

    @Override
    public String extractUuid(String token) {
        return validateToken(token).get("uuid",String.class);
    }

    @Override
    public String extractRole(String token) {
        return validateToken(token).get("role",String.class);
    }

    @Override
    public String extractSubject(String token) {
        return validateToken(token).getSubject();
    }

}