package com.prueba.backend.application.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.backend.application.dto.CityDTO;
import com.prueba.backend.application.dto.Response;
import com.prueba.backend.domain.City;
import com.prueba.backend.infrastructure.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public Response<CityDTO> addCity(CityDTO request){
        try {
            City city = objectMapper.convertValue(request, City.class);
            city = cityRepository.save(city);
            CityDTO saveCityDTO = objectMapper.convertValue(city, CityDTO.class);
            return new Response<>(200, "City create success", saveCityDTO);
        }
        catch (Exception ex)
        {
            return new Response<>(500,  "Error creating City" + ex.getMessage(), null);
        }
    }

    public Response<List<CityDTO>> findAllCities() {
        try {
            List<City> cities = cityRepository.findAll(); // Obtener todas las ciudades

            if (cities.isEmpty()) {
                return new Response<>(204, "No cities found.", Collections.emptyList());
            }

            List<CityDTO> cityDTOs = cities.stream()
                    .map(city -> objectMapper.convertValue(city, CityDTO.class))
                    .collect(Collectors.toList());

            return new Response<>(200, "Cities found", cityDTOs);

        } catch (Exception e) {
            return new Response<>(500, "Error when searching for cities: " + e.getMessage(), null);
        }
    }



}
