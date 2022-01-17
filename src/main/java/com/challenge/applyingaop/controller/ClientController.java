package com.challenge.applyingaop.controller;

import com.challenge.applyingaop.handle.ClientException;
import com.challenge.applyingaop.model.Client;
import com.challenge.applyingaop.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    Logger LOGGER = LogManager.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @GetMapping
    public void getClients(){
        clientService.getClients();
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable Long id){
        clientService.getClientId(id);
    }

    @PostMapping
    public void createClient(Client client){
        clientService.createClient();
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody Client client) throws ClientException{
        clientService.updateClient(client,id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
