package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

/**
 * AggregatorConfig
 */
public class AggregatorConfig {
    private final String windowSize;
    private final String slideDuration;

    public AggregatorConfig() {
        DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();
        windowSize = propertyFactory.getStringProperty("aggregator.windowSize", "30 minutes").get();
        slideDuration = propertyFactory.getStringProperty("aggregator.slideDuration", "30 minutes").get();
    }

    /**
     * Return the window size
     * Ex: 10 minutes, 30 minutes
     *
     * @return window size
     */
    public String getWindowSize() {
        return windowSize;
    }

    /**
     * Return the slide duration
     * Ex: 10 minutes, 20 minutes
     * @return slide duration
     */
    public String getSlideDuration() {
        return slideDuration;
    }
}
