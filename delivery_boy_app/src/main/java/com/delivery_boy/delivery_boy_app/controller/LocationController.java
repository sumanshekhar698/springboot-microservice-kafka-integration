package com.delivery_boy.delivery_boy_app.controller;


import com.delivery_boy.delivery_boy_app.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {

        for (int i = 0; i < 10000; i++) {
            this.kafkaService.updateLocation("[" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) +
                    "]");
        }

        return new ResponseEntity<>(Map.of("msg", "Location Updated"), HttpStatus.OK);

    }

}
