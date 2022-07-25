package com.virtusa.kafka;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.virtusa.kafka.entity.Employee;
import com.virtusa.kafka.entity.PaymentRequest;
import com.virtusa.kafka.entity.PurchaseRequest;
import com.virtusa.kafka.producer.Employee2JsonProducer;
import com.virtusa.kafka.producer.EmployeeJsonProducer;
import com.virtusa.kafka.producer.HelloKafkaProducer;
import com.virtusa.kafka.producer.KafkaKeyProducer;
import com.virtusa.kafka.producer.PaymentRequestProducer;
import com.virtusa.kafka.producer.PurchaseRequestProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {
	
//	@Autowired
//	private HelloKafkaProducer producer;
	
//	@Autowired
//	private KafkaKeyProducer producer;
	
//	@Autowired
//	private EmployeeJsonProducer producer;
	
//	@Autowired
//	private Employee2JsonProducer producer;
	
//	@Autowired
//	private PurchaseRequestProducer producer;
	
	@Autowired
	private PaymentRequestProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//producer.sendHello("Virtusa " + ThreadLocalRandom.current().nextInt());
		
		// generate message with key
//		for(int i = 0; i < 30; i++) {
//			var key = "Key-" + (i % 4);
//			var value = "value " + i + " with key " + key;
//			producer.send(key, value);
//		}
		
//		for(int i = 0; i < 5; i++ ) {
//			var emp = new Employee("emp" + i, "Employee " + i, LocalDate.now());
//			producer.sendMessage(emp);
//		}
		
		//PurchaseRequest
//		var pr1 = new PurchaseRequest(5554, "PR-Firsts", 991, "INR");
//		var pr2 = new PurchaseRequest(5555, "PR-Seconds", 992, "USD");
//		var pr3 = new PurchaseRequest(5556, "PR-Threee", 993, "USD");
//		
//		producer.send(pr1);
//		producer.send(pr2);
//		producer.send(pr3);
//		
//		producer.send(pr1);
		
		
		//Payment request 
		var paymentRequestAlpha_Transaction1 = new PaymentRequest("Payment-Alpha", 551, "USD", "Notes Alpha", "Budget Reserve");
		var paymentRequestAlpha_Transaction2 = new PaymentRequest("Payment-Alpha", 551, "USD", "Notes Alpha", "Aproval Workflow");
		var paymentRequestAlpha_Transaction3 = new PaymentRequest("Payment-Alpha", 551, "USD", "Notes Alpha", "Push notification");
		
		var paymentRequestBeta_Transaction1 = new PaymentRequest("Payment-Beta", 552, "USD", "Notes Beta", "Budget Reserve");
		var paymentRequestBeta_Transaction2 = new PaymentRequest("Payment-Beta", 552, "USD", "Notes Beta", "Aproval Workflow");
		var paymentRequestBeta_Transaction3 = new PaymentRequest("Payment-Beta", 553, "USD", "Notes Beta", "Push notification");
		
		
		producer.send(paymentRequestAlpha_Transaction1);
		producer.send(paymentRequestAlpha_Transaction2);
		producer.send(paymentRequestAlpha_Transaction3);
		
		producer.send(paymentRequestBeta_Transaction1);
		producer.send(paymentRequestBeta_Transaction2);
		producer.send(paymentRequestBeta_Transaction3);
		
		producer.send(paymentRequestAlpha_Transaction2);
		producer.send(paymentRequestBeta_Transaction3);
	}

}



















