package com.virtusa.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	KafkaTemplate<String, Product> kafkaTemplate;
	
	private static final String TOPIC = "vritusademotopictwo";
	
	@PostMapping("/product")
	public String publishMessage( @RequestBody Product product){
		
		kafkaTemplate.send(TOPIC, product);
		
		return "Published Successfully";
	}
	
//	@GetMapping("/publish/{message}")
//	public String publishMessage( @PathVariable("message") final String message){
//		
//		kafkaTemplate.send(TOPIC, message);
//		
//		return "Published Successfully";
//	}

}
