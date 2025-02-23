package com.prueba.backend.application.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {

    private String startDate;
    private  String endDate;

    public SearchDTO(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
