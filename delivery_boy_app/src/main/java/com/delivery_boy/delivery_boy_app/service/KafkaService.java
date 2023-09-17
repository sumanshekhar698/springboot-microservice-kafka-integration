package com.delivery_boy.delivery_boy_app.service;

import com.delivery_boy.delivery_boy_app.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = Logger.getLogger(KafkaService.class.getName());

    public boolean updateLocation(String location) {

        this.kafkaTemplate.send(Constants.LOCATION_TOPIC_NAME, location);
        this.logger.info("location message produced");

        return true;
    }

}
