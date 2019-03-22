package com.serefacet.bigdata.trendtopic.analyzer.filter;

import org.apache.spark.sql.Dataset;

/**
 * IFilter
 * @param <T> type of dataset
 */
public interface IFilter<T> {
    /**
     * Filter the given input
     * @param input data
     * @return filtered data
     */
    Dataset<T> filter(Dataset<T> input);
}
