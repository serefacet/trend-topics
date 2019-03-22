package com.serefacet.bigdata.trendtopic.analyzer.analyzer;

import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AnalyzerConfig;
import org.apache.spark.sql.Dataset;

/**
 * I analyzer
 * @param <T> return type of the analyzed dataset
 */
public interface IAnalyzer<T> {
    /**
     * Analyze the data according to config
     * @param config contains every configuration related to application
     * @return analyzed data
     */
    Dataset<T> analyze(AnalyzerConfig config);
}
