package com.challenge.restaurants.service;


import com.challenge.restaurants.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestauranteService {
    private static final Logger LOGGER = LogManager.getLogger(RestauranteService.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct(){
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }

    void mapperToString(Restaurante restaurante) throws JsonProcessingException{
        var restauranteString = mapper.writeValueAsString(restaurante);
        LOGGER.info("Mensaje en formato string : {}" , restauranteString);
    }

    void mapperToMap(Restaurante restaurante) throws JsonProcessingException{
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteMap = mapper.readValue(restauranteString, Map.class);
        LOGGER.info("Mensaje en formato de Mapa : {} ", restauranteMap);
    }

    void mapperToClass(Restaurante restaurante) throws JsonProcessingException{
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteClass = mapper.readValue(restauranteString, Restaurante.class);
        LOGGER.info("Mensaje en formato de Clase : {} ", restauranteClass);
    }

    public Restaurante createRestaurant(Restaurante restaurante){
        LOGGER.info("Se crea un restaurante");

        try{
            mapperToString(restaurante);
            mapperToMap(restaurante);
            mapperToClass(restaurante);
            return mongoTemplate.save(restaurante, "restaurantes");
        } catch (JsonProcessingException error) {
            LOGGER.error("Error convirtiendo a string" , error);
        }
        return restaurante;
    }

    public Map<String, Restaurante> restauranteStringToMap(String restaurante) throws JsonProcessingException{
        Map<String,Restaurante> restauranteMappeado = mapper.readValue(restaurante, Map.class);
        return restauranteMappeado;
    }
}
