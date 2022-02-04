package com.coderhouse.challenge.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public JedisConnectionFactory jeddisConnectionFactory(){
        var config = new RedisStandaloneConfiguration("127.0.0.1", 6380);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(){
        var redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(jeddisConnectionFactory());
        return redisTemplate;
    }
}
