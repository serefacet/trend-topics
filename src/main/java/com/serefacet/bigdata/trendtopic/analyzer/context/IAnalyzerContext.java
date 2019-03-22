package com.serefacet.bigdata.trendtopic.analyzer.context;

import com.serefacet.bigdata.trendtopic.analyzer.config.IAnalyzerConfig;
import org.apache.spark.sql.SparkSession;

/**
 * Analyzer Context
 */
public interface IAnalyzerContext {
    /**
     * Returns the spark session
     * @return spark session
     */
    SparkSession getSparkSession();

    /**
     * Returns the analyzer config
     * @return analyzer config
     */
    IAnalyzerConfig getConfig();
}
