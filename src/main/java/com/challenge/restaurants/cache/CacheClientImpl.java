package com.challenge.restaurants.cache;

import com.challenge.restaurants.config.ApplicationProperties;
import com.challenge.restaurants.model.Restaurante;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheClientImpl<T> implements CacheClient<T>{
    private final RedisTemplate<String, T> redisTemplate;
    private final ObjectMapper mapper;
    private HashOperations<String, String, String> hashOperations;
    private final ApplicationProperties properties;

    // PostConstruct executes when all beans of this class have been created correctly. It means, when all the injections are ready
    @PostConstruct
    void setHashOperations(){
        hashOperations = this.redisTemplate.opsForHash();
        this.redisTemplate.expire("mensaje-map", Duration.ofMillis(properties.getTimeOfLife()));
    }

    private String serializableItem(T item) throws JsonProcessingException{
        var serializableItem = mapper.writeValueAsString(item);
        log.info("Mensaje en formato String {} ", serializableItem);
        return serializableItem;
    }

    private T deserializableItem(String jsonInput, Class<T> classValue) throws JsonProcessingException{
        return mapper.readValue(jsonInput, classValue);
    }

    @Override
    public T save(String key, T data) {
        try{
            hashOperations.put("mensaje-map", key, serializableItem(data));
            return data;
        } catch (JsonProcessingException e){
            log.error("Error trying to convert restaurante to String", e);
        }
        return data;
    }

    @Override
    public T recover(String key, Class<T> classValue) {
        try{
            var item = hashOperations.get("mensaje-map", key);
            if(item == null) return null;
            return deserializableItem(item, classValue);
        } catch (JsonProcessingException e){
            log.error("Error trying to convert restaurante to Restaurante", e);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(id);
    }
}
