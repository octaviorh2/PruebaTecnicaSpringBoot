package com.prueba.backend.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private  String userName;
    private  String password;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}