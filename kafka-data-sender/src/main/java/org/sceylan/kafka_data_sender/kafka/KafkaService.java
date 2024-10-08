package org.sceylan.kafka_data_sender.kafka;
import org.sceylan.kafka_data_sender.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaProducer;
    public void sendData(Customer o)
    {
        try {
            //public ProducerRecord(String topic, K key, V value)
            String json = new ObjectMapper().writeValueAsString(o);        
            kafkaProducer.send("customer_data",o.getFirstName(),json);
            log.info("message sent");
            
        } catch (JsonProcessingException e) {
            // TODO: handle exception
            log.info("Error: when sending kafka message" + e.getMessage());
        }
        
    }

}
