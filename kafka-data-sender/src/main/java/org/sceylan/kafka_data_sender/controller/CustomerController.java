package org.sceylan.kafka_data_sender.controller;

import org.springframework.web.bind.annotation.RestController;
import org.sceylan.kafka_data_sender.bean.Customer;
import org.sceylan.kafka_data_sender.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CustomerController {
    @Autowired
    KafkaService kafkaService;

    @PostMapping("/api/customer")
    public Customer postMethodName(@RequestBody Customer entity) {
        //TODO: process POST request
        kafkaService.sendData(entity);
        return entity;
    }
    

}
