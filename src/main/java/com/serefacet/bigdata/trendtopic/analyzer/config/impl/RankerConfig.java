package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

public class RankerConfig {

    private final int topRecords;

    public RankerConfig() {
        topRecords = DynamicPropertyFactory.getInstance().getIntProperty("ranker.topRecords", 1).get();
    }

    /**
     * Returns the top records. This value specifies how many trend-topics will return in particular window.
     *
     * @return top records value
     */
    public int getTopRecords() {
        return topRecords;
    }

}
