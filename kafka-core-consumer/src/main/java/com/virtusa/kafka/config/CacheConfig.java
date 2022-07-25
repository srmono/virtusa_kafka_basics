package com.virtusa.kafka.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.virtusa.kafka.consumer.PaymentRequestCacheKey;

@Configuration
public class CacheConfig {

	@Bean(name = "cachePurchaseRequest")
	public Cache<Integer, Boolean> cachePurchaseReqest() {
		return Caffeine.newBuilder()
				.expireAfterWrite(Duration.ofMinutes(2))
				.maximumSize(1000).build();
	}
	
	@Bean(name = "cachePaymentRequest")
	public Cache<PaymentRequestCacheKey, Boolean> cachePaymentReqest() {
		return Caffeine.newBuilder()
				.expireAfterWrite(Duration.ofMinutes(2))
				.maximumSize(1000).build();
	}
}
