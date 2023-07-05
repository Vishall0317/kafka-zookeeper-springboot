package com.learning.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.learning.kafka.model.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="firstJsonTopic", groupId="groupId")
	public void consumeUser(User user) {
		LOGGER.info("User cunsume "+ user.toString());
	}

}
