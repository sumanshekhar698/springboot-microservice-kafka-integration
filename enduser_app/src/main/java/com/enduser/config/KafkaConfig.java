package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;

@Configuration
public class KafkaConfig {


    private Logger logger = Logger.getLogger(KafkaConfig.class.getName());


    @KafkaListener(topics = Constants.LOCATION_UPDATE_TOPIC, groupId = Constants.GROUP_ID)
    public void updatedLocation(String value) {
        logger.info("Location of Delivery Boy :: " + value);

    }
}
