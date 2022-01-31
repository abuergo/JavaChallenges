package com.challenge.restaurants.cache;

import com.challenge.restaurants.model.Restaurante;

public interface CacheClient<T> {

    T save(String key, T data);
    T recover(String key, Class<T> classValue);
    void delete(String id);

}
