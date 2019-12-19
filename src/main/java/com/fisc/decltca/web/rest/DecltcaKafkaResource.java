package com.fisc.decltca.web.rest;

import com.fisc.decltca.service.DecltcaKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decltca-kafka")
public class DecltcaKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecltcaKafkaResource.class);

    private DecltcaKafkaProducer kafkaProducer;

    public DecltcaKafkaResource(DecltcaKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
