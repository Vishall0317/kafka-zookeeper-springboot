package com.kafka.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikipediaChangesService {
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
		
	public void sendMessage() throws InterruptedException {
		// to read real time stream data from wikimedia, we use event source
		String topicName="wikipedia-recentchange";
		EventHandler eventHandler = new WikipediaChangesHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
		
	}
	
}
