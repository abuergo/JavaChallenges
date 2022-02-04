package com.coderhouse.challenge.cache;

import com.coderhouse.challenge.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheClientImplementation<T> implements CacheClient<T>{

    private final RedisTemplate<String, T> redisTemplate;
    private HashOperations<String, String, String> hashOperations;
    private final ObjectMapper mapper;

    @PostConstruct
    void setHashOperations(){
        hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public T save(String key, T data) {
        try{
            hashOperations.put(Constants.NAME_MAP_USER, key, serializeItem(data));
            return data;
        } catch (JsonProcessingException e) {
            log.error("Error trying to convert data to String", e);
        }

        return data;
    }

    private String serializeItem(T item) throws JsonProcessingException{
        var serializeItem = mapper.writeValueAsString(item);
        log.info("User in String format : {}", serializeItem);
        return serializeItem;
    }

    private T deserializeItem(String jsonInput, Class<T> classValue) throws JsonProcessingException {
        return mapper.readValue(jsonInput, classValue);
    }

    @Override
    public T recover(String key, Class<T> classValue) {
        try {
            var item = hashOperations.get(Constants.NAME_MAP_USER, key);
            if (item == null) return null;
            return deserializeItem(item, classValue);
        } catch (JsonProcessingException e) {
            log.error("Error converting user to User", e);
        }
        return null;
    }
}
