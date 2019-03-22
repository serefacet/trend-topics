package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

public class ReceiverConfig {

    private final JsonConfig jsonConfig;
    private final KafkaConfig kafkaConfig;

    public ReceiverConfig(){
        this.jsonConfig = new JsonConfig();
        this.kafkaConfig = new KafkaConfig();
    }

    /**
     * Returns the Receiver Json Configuration
     * @return receiver json config
     */
    public JsonConfig getJsonConfig() {
        return jsonConfig;
    }

    /**
     * Returns the Receiver Kafka Configuration
     * @return receiver kafka config
     */
    public KafkaConfig getKafkaConfig() {
        return kafkaConfig;
    }
}
