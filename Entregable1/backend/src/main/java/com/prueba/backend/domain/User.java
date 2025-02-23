package com.prueba.backend.domain;







import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String userName;
    private  String password;

    public  User(){}
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}



