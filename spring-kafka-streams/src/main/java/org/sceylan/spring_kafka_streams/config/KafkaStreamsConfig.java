package org.sceylan.spring_kafka_streams.config;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.sceylan.spring_kafka_streams.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamsConfig {

    @Bean
    public KafkaStreams kafkaStreams()
    {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "customer-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, org.apache.kafka.common.serialization.Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerde.class.getName());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String,Customer> customerStream = builder.stream("customer_data");
        customerStream
            .mapValues((ValueMapper<Customer, String>) customer -> "Name length: " + customer.getFirstName().length() + customer.getLastName().length())
            .to("updated_data", Produced.with(org.apache.kafka.common.serialization.Serdes.String(), org.apache.kafka.common.serialization.Serdes.String()));

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
        return streams;
    }
}
