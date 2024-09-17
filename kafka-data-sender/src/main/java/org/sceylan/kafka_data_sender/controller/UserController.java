package org.sceylan.kafka_data_sender.controller;

import org.springframework.web.bind.annotation.RestController;
import org.sceylan.kafka_data_sender.bean.User;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    @GetMapping("/api")
    public User getMethodName() {
        return new User("ok",1);
    }
    
     
}
