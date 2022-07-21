package com.virtusa.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.kafka.entity.CarLocation;

@Configuration
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	public ConsumerFactory<Object, Object> consumerFactory(){
		var properties = kafkaProperties.buildConsumerProperties();
		
		properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");
		
		return new DefaultKafkaConsumerFactory<>(properties);
	}
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Bean(name = "farLocationContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> farLocationContainerFactory(
				ConcurrentKafkaListenerContainerFactoryConfigurer configurer){
		
		var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
		
		configurer.configure(factory, consumerFactory());
		
		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {

			@Override
			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
				// TODO Auto-generated method stub
				
				try {
					CarLocation carLocation = objectMapper.readValue(consumerRecord.value().toString(),  CarLocation.class);
					return carLocation.getDistance() <= 100;
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					return false;
				}
				
				
			}
		});
		
		return factory;
		
	}
}









