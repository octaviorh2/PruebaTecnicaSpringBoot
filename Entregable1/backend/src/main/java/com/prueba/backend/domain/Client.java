package com.prueba.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "client")
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String nit;

    private String namePoint;
    private String nameTeam;
    private String city;
    private String rtc;
    private String promoter;
    private String captain;
    private boolean treatmentData;
    private String ipClient;
    private LocalDate dateRecord;
    private LocalTime timeRecord;

    public Client(){}

    public Client(String name, String nit, String namePoint, String nameTeam, String city, String rtc, String promoter, String captain, boolean treatmentData, String ipClient, LocalDate dateRecord, LocalTime timeRecord) {
        this.name = name;
        this.nit = nit;
        this.namePoint = namePoint;
        this.nameTeam = nameTeam;
        this.city = city;
        this.rtc = rtc;
        this.promoter = promoter;
        this.captain = captain;
        this.treatmentData = treatmentData;
        this.ipClient = ipClient;
        this.dateRecord = dateRecord;
        this.timeRecord = timeRecord;
    }
}
