package com.tracking.delivery.service;

import com.tracking.delivery.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String>  kafkaTemplate;       //send msg using kafka template <key,val>

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public boolean updateLocation(String location) {
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC, location);
        logger.info("message produced");
        return true;
    }
}
