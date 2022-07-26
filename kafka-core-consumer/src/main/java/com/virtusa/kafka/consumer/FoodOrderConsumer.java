package com.virtusa.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.kafka.entity.FoodOrder;

//@Service
public class FoodOrderConsumer {

	public static final Logger LOG = LoggerFactory.getLogger(FoodOrderConsumer.class);
	
	public static final int MAX_ORDER_AMOUNT = 40;
	
	@Autowired
	public ObjectMapper objectMapper;
	
	@KafkaListener(topics = "t-food-order", errorHandler = "myFoodOrderErrorHandler")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		var foodOrder = objectMapper.readValue(message, FoodOrder.class);
		
		if(foodOrder.getAmount() > MAX_ORDER_AMOUNT) {
			throw new IllegalArgumentException("Order amount is too high: " + foodOrder.getAmount());
		}
		
		LOG.info("Processing food order: {} ", foodOrder);
		
	}
	
}
