package com.prueba.backend.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id ;
    private String  name ;

    public City( String name) {

        this.name = name;
    }

    public City(){}

}
