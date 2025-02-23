package com.prueba.backend.application.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.backend.application.dto.LoginDTO;
import com.prueba.backend.application.dto.Response;
import com.prueba.backend.application.dto.UserDTO;
import com.prueba.backend.domain.User;
import com.prueba.backend.infrastructure.repository.UserRepository;
import com.prueba.backend.infrastructure.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Response<String>addUser(UserDTO request){
        try{
            User user = objectMapper.convertValue(request , User.class);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user = userRepository.save(user);
            return new Response<>(200, "User create success", null);

        }catch (Exception ex){
            return new Response<>(500,  "Error creating User" + ex.getMessage(), null);
        }
    }
    public Response<String> loginUser(LoginDTO request){

        try
        {
            User user = userRepository.findByUsername(request.getUserName());
            if (user == null) {
                return new Response<>(401, "Invalid credentials", null);
            }
            // Verificamos la contraseña ingresada con la almacenada en la BD
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return new Response<>(401, "Invalid credentials", null);
            }
            String token = jwtUtil.generateToken(user.getUserName());

            return new Response<>(200, "Login successful", token);

        } catch (Exception ex) {
            return new Response<>(500,  "Error Login " + ex.getMessage(), null);
        }

    }




}
