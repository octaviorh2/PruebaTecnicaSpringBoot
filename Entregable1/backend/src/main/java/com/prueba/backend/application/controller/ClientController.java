package com.prueba.backend.application.controller;

import com.prueba.backend.application.dto.ClientDTO;
import com.prueba.backend.application.dto.Response;
import com.prueba.backend.application.dto.SearchDTO;
import com.prueba.backend.application.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Response<ClientDTO>> createClient(@RequestBody ClientDTO clientDTO) {
        Response<ClientDTO> clientResponse = clientService.addClient(clientDTO);
        return ResponseEntity.ok(clientResponse);

    }

    @PostMapping("/by-date")
    public ResponseEntity<Response<List<ClientDTO>>> getClientsByDateRange(@RequestBody SearchDTO request) {
        Response<List<ClientDTO>> response = clientService.findByDateRecordBetween(request);
        return ResponseEntity.ok(response);

    }


}
