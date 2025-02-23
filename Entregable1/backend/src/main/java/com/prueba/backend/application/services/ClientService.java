package com.prueba.backend.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.backend.application.dto.ClientDTO;
import com.prueba.backend.application.dto.Response;
import com.prueba.backend.application.dto.SearchDTO;
import com.prueba.backend.domain.Client;
import com.prueba.backend.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {



    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public Response<ClientDTO> addClient(ClientDTO request){
        try {
            Client client = objectMapper.convertValue(request, Client.class);
            client = clientRepository.save(client);
            ClientDTO saveClientDTO = objectMapper.convertValue(client, ClientDTO.class);
            return new Response<>(200, "Client create success", saveClientDTO);
        }
        catch (Exception ex)
        {
            return new Response<>(500,  "Error creating client" + ex.getMessage(), null);
        }
    }

    public Response<List<ClientDTO>> findByDateRecordBetween(SearchDTO request) {
        try {
            List<Client> clients = clientRepository.findByDateRecordBetween(request.getStartDate(), request.getEndDate());

            if (clients.isEmpty()) {
                return new Response<>(204, "No clients found in the date range.", Collections.emptyList());
            }

            List<ClientDTO> clientDTOs = clients.stream()
                    .map(client -> objectMapper.convertValue(client, ClientDTO.class))
                    .collect(Collectors.toList());

            return new Response<>(200, "Clients found", clientDTOs);

        } catch (Exception e) {
            return new Response<>(500, "Error when searching for clients:" + e.getMessage(), null);
        }
    }








}
