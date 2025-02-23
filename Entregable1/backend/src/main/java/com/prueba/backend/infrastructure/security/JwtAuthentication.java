package com.prueba.backend.infrastructure.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthentication extends UsernamePasswordAuthenticationToken {



    public JwtAuthentication(String username) {
        // Pasamos el nombre de usuario y dejamos la contraseña como null (no la necesitamos con JWT)
        super(username, null);
    }


}
