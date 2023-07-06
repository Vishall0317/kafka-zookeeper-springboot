package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikipediaChangesHandler implements EventHandler{

	private static final Logger LOGGER= LoggerFactory.getLogger(WikipediaChangesHandler.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;
	
	public WikipediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
	
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("event data "+ messageEvent.getData());
		kafkaTemplate.send(topic, messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
