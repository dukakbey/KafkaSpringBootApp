package org.sceylan.kafka_data_sender.kafka;

import java.util.Properties;

public class KafkaProducerConfig {
    private static Properties properties = new Properties();
    public static Properties getConfig()
    {
        properties.setProperty("","");
        properties.setProperty("","");
        properties.setProperty("","");
        properties.setProperty("","");
        properties.setProperty("","");
        return properties;
    }

}
