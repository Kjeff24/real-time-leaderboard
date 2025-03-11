package com.bexos.real_time_leaderboard.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import java.time.Duration;

/**
 * Configuration class for Redis caching.
 * This class defines cache settings, including default TTL (Time To Live) and serialization format.
 */
@Configuration
@RequiredArgsConstructor
public class RedisConfig {
    // Injects the Redis connection factory for establishing Redis connections
    private final RedisConnectionFactory redisConnectionFactory;

    /**
     * Defines the RedisCacheManager bean, which manages cache settings.
     * The default cache expiration is set to 10 minutes.
     * A custom expiration of 5 minutes is applied for the "leaderboard" cache.
     *
     * @return RedisCacheManager instance
     */
    @Bean
    public RedisCacheManager cacheManager() {
        // Default cache configuration with a TTL of 10 minutes
        RedisCacheConfiguration cacheConfig = myDefaultCacheConfig(Duration.ofMinutes(10))
                .disableCachingNullValues(); // Prevents caching of null values

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfig) // Set default cache settings
                .withCacheConfiguration("leaderboard", myDefaultCacheConfig(Duration.ofMinutes(5))) // Custom TTL for leaderboard cache
                .build();
    }

    /**
     * Creates a RedisCacheConfiguration with a specified TTL and JSON serialization.
     *
     * @param duration The time-to-live (TTL) duration for cache entries
     * @return RedisCacheConfiguration instance
     */
    private RedisCacheConfiguration myDefaultCacheConfig(Duration duration) {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(duration) // Sets the expiration time for cached data
                .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
