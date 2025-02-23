package com.prueba.backend.application.services;

import com.prueba.backend.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usa tu entidad User para buscar en la BD
        com.prueba.backend.domain.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), // Nombre de usuario desde tu entidad
                user.getPassword(), // Contraseña encriptada desde tu entidad
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")) // Rol por defecto
        );
    }
}