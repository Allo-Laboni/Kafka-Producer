package com.kafkapractice.kafkapractice.controller;

import com.kafkapractice.kafkapractice.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message) {
        try {
            kafkaService.sendMessageToTopic(message);
            return ResponseEntity.ok("Message sent to Kafka successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}