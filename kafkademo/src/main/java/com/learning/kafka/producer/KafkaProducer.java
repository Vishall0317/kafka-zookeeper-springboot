package com.learning.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate kafkaTemplate;

	public void sendMessage(String message) {
		LOGGER.info("Message send "+ message);
		kafkaTemplate.send("firstTopic", message);
	}
}
