package org.sceylan.kafka_data_sender.kafka;
import org.sceylan.kafka_data_sender.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaProducer;
    public void sendData(Customer o)
    {
        try {
            //public ProducerRecord(String topic, K key, V value)
            String json = new ObjectMapper().writeValueAsString(o);        
            kafkaProducer.send("customer_data",o.getFirstName(),json);
            System.out.println("message sent");
            
        } catch (JsonProcessingException e) {
            // TODO: handle exception
            System.out.println("Error: when sending kafka message" + e.getMessage());
        }
        
    }

}
