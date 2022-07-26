package com.virtusa.kafka.error.handler;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;

import com.virtusa.kafka.consumer.SimpleNumberConsumer;

public class GlobalErrorHandler implements ConsumerAwareErrorHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerAwareErrorHandler.class);

	@Override
	public void handle(Exception thrownException, ConsumerRecord<?, ?> data, Consumer<?, ?> consumer) {
		
		LOG.warn("Global error handler for message: {} ", data.value().toString());
	}

}
