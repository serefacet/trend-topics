package com.serefacet.bigdata.trendtopic.analyzer.aggregator;

import org.apache.spark.sql.Dataset;

/**
 * IAggregator
 *
 * @param <T> input type of dataset
 * @param <R> return type of dataset
 */
public interface IAggregator<T,R> {
    /**
     * Aggregate the input data
     * @param input dataset
     * @return aggregated dataset
     */
    Dataset<R> aggregate(Dataset<T> input);
}
