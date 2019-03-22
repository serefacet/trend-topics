package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

/**
 * JsonConfig
 */
public class JsonConfig {
    private final String path;

    public JsonConfig() {
        this.path = DynamicPropertyFactory.getInstance().getStringProperty("receiver.json.path", "src/main/resources/data").get();
    }

    /**
     * Returns the path of the input JSON file
     * @return the json path
     */
    public String getPath() {
        return path;
    }
}
