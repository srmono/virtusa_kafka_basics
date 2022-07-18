package com.virtusa.kafka;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.virtusa.kafka.producer.HelloKafkaProducer;
import com.virtusa.kafka.producer.KafkaKeyProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {
	
//	@Autowired
//	private HelloKafkaProducer producer;
	
	@Autowired
	private KafkaKeyProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//producer.sendHello("Virtusa " + ThreadLocalRandom.current().nextInt());
		
		for(int i = 0; i < 30; i++) {
			var key = "Key-" + (i % 4);
			var value = "value " + i + " with key " + key;
			producer.send(key, value);
		}
	}

}
