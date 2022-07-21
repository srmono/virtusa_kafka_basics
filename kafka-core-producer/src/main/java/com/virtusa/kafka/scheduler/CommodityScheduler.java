package com.virtusa.kafka.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.virtusa.kafka.entity.Commodity;
import com.virtusa.kafka.producer.CommodityProducer;

//@Service
public class CommodityScheduler {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CommodityProducer producer;
	
	@Scheduled(fixedRate = 5000)
	public void fetchCommodites() {
		var commodities = restTemplate.exchange(
				"http://localhost:8080/api/commodity/v1/all", 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Commodity>>() {
				}).getBody();
		
		commodities.forEach(t -> {
			try {
				producer.sendMessage(t);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
}
