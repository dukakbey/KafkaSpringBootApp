package org.sceylan.kafka_data_sender.controller;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.sceylan.kafka_data_sender.bean.Customer;
import org.sceylan.kafka_data_sender.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    KafkaService kafkaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postMethodName(@RequestBody @Valid Customer c) {        
        c.setTimestamp(LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond());
        kafkaService.sendData(c);
        return c;
    }
    

}
