package com.serefacet.bigdata.trendtopic.analyzer.config;

import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AggregatorConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.FilterConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.PersisterConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.RankerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.ReceiverConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.SparkConfig;

/**
 * Analyzer Config
 *
 * This class holds every configuration related to application.
 */
public interface IAnalyzerConfig {
    /**
     * Returns the spark configuration
     * @return spark config
     */
    SparkConfig getSparkConfig();

    /**
     * Returns the receiver configuration
     * @return receiver config
     */
    ReceiverConfig getReceiverConfig();

    /**
     * Returns the filter configuration
     * @return filter config
     */
    FilterConfig getFilterConfig();

    /**
     * Returns the aggregator configuration
     * @return aggregator config
     */
    AggregatorConfig getAggregatorConfig();

    /**
     * Returns the ranker configuration
     * @return rank config
     */
    RankerConfig getRankerConfig();

    /**
     * Returns the persister configuration
     * @return persister config
     */
    PersisterConfig getPersisterConfig();
}
