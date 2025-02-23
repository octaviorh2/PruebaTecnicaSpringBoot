package com.prueba.backend.application.controller;


import com.prueba.backend.application.dto.CityDTO;
import com.prueba.backend.application.dto.Response;
import com.prueba.backend.application.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired
    private CityService cityService;


    @PostMapping
    public ResponseEntity<Response<CityDTO>> addCity(@RequestBody CityDTO request) {
        Response<CityDTO> cityResponse = cityService.addCity(request);
        return ResponseEntity.ok(cityResponse);

    }
    @GetMapping("/allCity")
    public ResponseEntity<Response<List<CityDTO>>> getAllCities() {
        Response<List<CityDTO>> response = cityService.findAllCities();
        return ResponseEntity.ok(response);
    }



}
