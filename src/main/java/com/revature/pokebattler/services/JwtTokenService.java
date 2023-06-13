package com.revature.pokebattler.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.revature.pokebattler.dtos.responses.Principal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService {
    @Value("$jwt.secret")
    private String SECRET_KEY;

    public String generateToken(Principal principal){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", principal.getId());
        claims.put("role", principal.getRole());

        return Jwts.builder()
        .setClaims(claims)
        .setSubject(principal.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // means 10 hours
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
    }

    public boolean validateToken(String token, Principal userPrincipal){
        String tokenUsername = extractUserName(token);
        return tokenUsername.equals(userPrincipal.getUsername());
    }

    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String extractUserId(String token){
        return (String) extractAllClaims(token).get("id");
    }

    public String extractUserRole(String token){
        return (String) extractAllClaims(token).get("role");
    }


}
