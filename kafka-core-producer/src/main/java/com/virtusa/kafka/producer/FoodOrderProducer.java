package com.virtusa.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.kafka.entity.FoodOrder;

@Service
public class FoodOrderProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void send(FoodOrder foodOrder) throws JsonProcessingException {
		
		var json = objectMapper.writeValueAsString(foodOrder);
		
		kafkaTemplate.send("t-food-order", json);
	}

}







