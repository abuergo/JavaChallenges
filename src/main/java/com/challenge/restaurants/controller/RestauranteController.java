package com.challenge.restaurants.controller;

import com.challenge.restaurants.model.Restaurante;
import com.challenge.restaurants.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestauranteController {
    private static final Logger LOGGER = LogManager.getLogger(RestauranteController.class);

    @Autowired
    RestauranteService service;

    @PostMapping("/restaurante")
    private Restaurante createRestaurant(@RequestBody Restaurante restaurante){
        return service.createRestaurant(restaurante);
    }

    @PostMapping("/restaurante/toMap")
    public Map<String, Restaurante> restauranteMap (@RequestBody @Validated String restaurante) throws JsonProcessingException{
        return service.restauranteStringToMap(restaurante);
    }
}
