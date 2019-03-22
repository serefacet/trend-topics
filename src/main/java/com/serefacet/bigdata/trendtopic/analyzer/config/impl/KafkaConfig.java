package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

public class KafkaConfig {

    private final String bootstrapServers;
    private final String topicName;

    public KafkaConfig() {
        bootstrapServers = DynamicPropertyFactory.getInstance().getStringProperty("receiver.kafka.bootstrap.servers", "localhost:9092").get();
        topicName = DynamicPropertyFactory.getInstance().getStringProperty("receiver.kafka.topic.name", "meetup").get();
    }

    /**
     * Returns the Kafka bootstrap servers
     * @return kafka bootstrap servers
     */
    public String getBootstrapServers() {
        return bootstrapServers;
    }

    /**
     * Returns the target topic name of Kafka
     * @return kafka topic name
     */
    public String getTopicName() {
        return topicName;
    }
}
