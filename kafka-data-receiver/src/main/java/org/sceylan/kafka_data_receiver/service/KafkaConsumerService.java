package org.sceylan.kafka_data_receiver.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
 
    @KafkaListener(topics = "customer_data",groupId = "barisdere1")
    public static void receiveData(String m)
    {
        System.out.println("Received Message: " + m);
    }
}
