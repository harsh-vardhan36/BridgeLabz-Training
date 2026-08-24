package com.fundoo.notes.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@EnableCaching
public class RedisConfig {

    @Value("${app.cache.ttl-minutes:10}")
    private long cacheTtlMinutes;

    /**
     * Backs @Cacheable/@CacheEvict (see NoteServiceImpl). Keys are stored as
     * plain strings and values as JSON so entries are human-readable if you
     * inspect them with `redis-cli` (e.g. `KEYS *`, `GET userNotes::a@b.com`).
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(cacheTtlMinutes))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(redisJsonSerializer()));

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }

    // GenericJackson2JsonRedisSerializer builds its own internal ObjectMapper
    // (Jackson 2 -- unrelated to Spring Boot's auto-configured Jackson 3
    // JsonMapper used for HTTP responses), and that internal mapper does NOT
    // have JavaTimeModule registered by default. Cached DTOs here
    // (NoteResponseDTO, with LocalDateTime createdAt/updatedAt/reminderAt)
    // would fail to serialize into Redis without this.
    private GenericJackson2JsonRedisSerializer redisJsonSerializer() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return new GenericJackson2JsonRedisSerializer(mapper);
    }
}