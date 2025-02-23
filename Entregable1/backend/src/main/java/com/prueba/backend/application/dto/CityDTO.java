package com.prueba.backend.application.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {
    private String  name ;

    public CityDTO( String name) {

        this.name = name;
    }
}
