package com.jakuch.IRequireOrder.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
class CacheConfiguration {


    @Bean
    public CacheManager cacheManager() {
        var cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(
                new CaffeineCache("spells",
                        Caffeine.newBuilder()
                                .expireAfterWrite(60, TimeUnit.MINUTES)
                                .maximumSize(2000)
                                .build()
                ),
                new CaffeineCache("classes",
                        Caffeine.newBuilder()
                                .expireAfterWrite(60, TimeUnit.MINUTES)
                                .maximumSize(100)
                                .build()
                ),
                new CaffeineCache("races",
                        Caffeine.newBuilder()
                                .expireAfterWrite(60, TimeUnit.MINUTES)
                                .maximumSize(100)
                                .build()
                )
        ));

        return cacheManager;
    }
}
