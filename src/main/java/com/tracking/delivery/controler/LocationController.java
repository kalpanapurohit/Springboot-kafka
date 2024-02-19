package com.tracking.delivery.controler;


import com.tracking.delivery.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + ")");
        return new ResponseEntity<>(Map.of("message", "Location-update"), HttpStatus.OK);
    }
}
