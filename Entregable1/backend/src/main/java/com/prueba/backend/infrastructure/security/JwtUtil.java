package com.prueba.backend.infrastructure.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.stereotype.Component;



@Component
public class JwtUtil {

    private String SECRET_KEY = "SNDVNSDNSJDSNDLK123124324564575424nkndlkwdnflvndks213123";

    // Generar el token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Expira en 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Extraer el nombre de usuario del token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Extraer las claims (información) del token
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Verificar si el token está expirado
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Validar el token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}