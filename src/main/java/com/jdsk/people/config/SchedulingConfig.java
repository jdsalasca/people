package com.jdsk.people.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulingConfig {
	
	@Autowired
	private CacheManager cacheManager;
		
	   @Scheduled(fixedRate = 60000 *5) // runs every minute
	    public void evictAllCaches() {
		   log.info("Deleting cache");
		   
	        cacheManager.getCacheNames()
	                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	    }
}
