package com.jdsk.people.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {
	
	   @Bean
	     CacheManager cacheManager() {
	        SimpleCacheManager cacheManager = new SimpleCacheManager();
	        cacheManager.setCaches(Arrays.asList(
	                new ConcurrentMapCache("personCache"),
	                new ConcurrentMapCache("heavyTask")
	                
	        ));
	        return cacheManager;
	    }
	   



}
