package com.serefacet.bigdata.trendtopic.analyzer.ranker;

import org.apache.spark.sql.Dataset;

/**
 * Ranker
 * @param <T> type of input dataset
 * @param <R> type of output dataset
 */
public interface IRanker<T,R> {
    /**
     * Rank the given dataset data
     * @param input aggregated dataset
     * @return ranked dataset
     */
    Dataset<R> rank(Dataset<T> input);
}
