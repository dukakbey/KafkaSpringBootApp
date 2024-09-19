package org.sceylan.kafka_data_receiver.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
 
    // // @KafkaListener(topics = "customer_data")
    // @KafkaListener(topics = "customer_data")
    // public static void receiveData(String m)
    // {
    //     System.out.println("Received Message customer_data: " + m);
    // }
    @KafkaListener(topics = "updated_data")
    public static void receiveUptdatedData(String m)
    {
        try {
            // String olarak alınan mesajı Long'a dönüştür
            Long length = Long.parseLong(m);
            System.out.println("Received Message updated_data: " + length);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing message: " + m);
        }
     
    }
}
