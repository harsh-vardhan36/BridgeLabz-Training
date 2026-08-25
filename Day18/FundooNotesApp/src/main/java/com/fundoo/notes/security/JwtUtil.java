package com.fundoo.notes.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fundoo.notes.entity.User;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Pulled from application.properties -> .env (jwt.secret / JWT_SECRET).
    // Never hardcode this in source control.
    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration-ms}")
    private long EXPIRATION;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // Accept User object so we can access role
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) 
                .claim("role", user.getRole()) // embed role claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    // Needed so callers can compare "when was this token issued" against
    // "when did the user's password last change" to invalidate stale tokens.
    public Date extractIssuedAt(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getIssuedAt();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}

