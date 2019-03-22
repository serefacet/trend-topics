package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

/**
 * PersisterConfig
 */
public class PersisterConfig {
    private final String destination;

    public PersisterConfig() {
        this.destination = DynamicPropertyFactory.getInstance().getStringProperty("persister.destination", "trendtopic-output").get();
    }

    public String getDestination() {
        return destination;
    }
}
