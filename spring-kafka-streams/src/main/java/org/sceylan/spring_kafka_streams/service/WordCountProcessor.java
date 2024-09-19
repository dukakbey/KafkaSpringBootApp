package org.sceylan.spring_kafka_streams.service;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
@EnableKafkaStreams
public class WordCountProcessor {
  private static final Serde<String> STRING_SERDE = Serdes.String();
  private static final Serde<Long> LONG_SERDE = Serdes.Long();

  @Autowired
  void buildPipeline(StreamsBuilder streamsBuilder) {
    KStream<String, String> messageStream = streamsBuilder
        .stream("customer_data", Consumed.with(STRING_SERDE, STRING_SERDE));

    KStream<String, Long> lengthCounts = messageStream
        .mapValues((ValueMapper<String, Long>) value -> (long) value.length());

    lengthCounts.to("updated_data", Produced.with(STRING_SERDE, LONG_SERDE));
  }

}