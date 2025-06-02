/*
 * JwtUtil.java
 * 
 * Utility class for managing JSON Web Tokens (JWT) using a symmetric secret key.
 * 
 * Key Features:
 * - Generates JWT tokens for authenticated users.
 * - Parses JWT tokens to extract claims such as username and expiration.
 * - Validates JWT tokens for authenticity and expiration.
 * - Uses a symmetric HMAC SHA-256 secret key for signing tokens.
 * - Provides helper methods to work with claims securely and consistently.
 * 
 * Security:
 * - Relies on a strong 256-bit secret key for signing and validating tokens.
 * - Tokens include issued time and expiration to prevent replay attacks.
 * 
 * Dependencies:
 * - JJWT (io.jsonwebtoken) library for JWT creation and parsing.
 * - Java Cryptography (javax.crypto) for key management.
 * - Spring Framework's @Component annotation for dependency injection.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */
package com.hexaware.automobile.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final String SECRET = "your-256-bit-secret-your-256-bit-secret"; 
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 1000; 

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        return createToken(username);
    }

    private String createToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
