package com.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.model.WikimediaData;
import com.kafka.consumer.repository.WikimediaDataRepository;

@Service
public class WikipediaChangesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WikipediaChangesService.class);
	
	@Autowired
	private WikimediaDataRepository dataRepository;
		
	@KafkaListener(topics = "wikipedia-recentchange", groupId = "groupId")
    public void consume(String eventMessage){

        LOGGER.info("Event message received "+ eventMessage);

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);
    }
	
}
