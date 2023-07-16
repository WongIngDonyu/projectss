package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    Iterable<ClientDto> all()
    {
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    ClientDto one(@PathVariable Integer id) throws  Throwable {
        return (ClientDto) clientService.findClient(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PostMapping("/clients")
        ClientDto newClient(@RequestBody ClientDto newClient){
            return clientService.add(newClient);
        }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Integer id) {clientService.expel(id);}
}
