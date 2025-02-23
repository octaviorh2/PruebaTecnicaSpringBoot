package com.prueba.backend.application.controller;


import com.prueba.backend.application.dto.*;
import com.prueba.backend.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Response<String>> addUser(@RequestBody UserDTO request) {
        Response<String> userResponse = userService.addUser(request);
        return ResponseEntity.ok(userResponse);

    }

    @PostMapping("/Login")
    public ResponseEntity<Response<String>> getClientsByDateRange(@RequestBody LoginDTO request) {
        Response<String> loginResponse = userService.loginUser(request);
        return ResponseEntity.ok(loginResponse);

    }
}
