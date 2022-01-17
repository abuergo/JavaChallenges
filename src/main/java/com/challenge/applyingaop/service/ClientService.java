package com.challenge.applyingaop.service;

import com.challenge.applyingaop.annotations.CustomMethodAnnotation;
import com.challenge.applyingaop.handle.ClientException;
import com.challenge.applyingaop.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    Logger LOGGER = LogManager.getLogger();

    public void getClients(){
        LOGGER.info("A list of clients is returned");
    }

    public void createClient(){
        LOGGER.info("A client is created");
    }

    public void getClientId(Long id){
        LOGGER.info("A client with ID " + id + " is returned");
    }

    // These methods with CustomMethodAnnotation, are used as a pointcut on the interceptor file
    @CustomMethodAnnotation
    public void updateClient(Client client, Long id) throws ClientException{
        if(client.getName() == "" || client.getName() == null){
            throw new ClientException("Client name is empty");
        }
        LOGGER.info("A client is updated");
    }

    @CustomMethodAnnotation
    public void deleteClient(Long id){
        LOGGER.info("A client with ID " + id + " is deleted");
    }
}
