package org.sceylan.kafka_data_sender.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private KafkaProducer<String,Object> kafkaProducer = new KafkaProducer<>(KafkaProducerConfig.getConfig());
    public void sendData(Object o)
    {
        //public ProducerRecord(String topic, K key, V value)
        ProducerRecord<String,Object> producerRecord = new ProducerRecord<>(null, o);
        kafkaProducer.send(producerRecord);
    }

}
