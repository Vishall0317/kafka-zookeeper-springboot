package com.learning.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.learning.kafka.model.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendUser(User user) {
		
		LOGGER.info("User send "+ user.toString());
		
		Message<User> message= MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "firstJsonTopic")
				.build();
		
		kafkaTemplate.send(message);
	}

}
