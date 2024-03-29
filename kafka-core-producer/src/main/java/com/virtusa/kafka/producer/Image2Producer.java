package com.virtusa.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.kafka.entity.Image;

//@Service
public class Image2Producer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	public void send(Image image, int partition) throws JsonProcessingException {
		var json = objectMapper.writeValueAsString(image);
		
		kafkaTemplate.send("t-image-2", partition, image.getType(), json);
	}
}






