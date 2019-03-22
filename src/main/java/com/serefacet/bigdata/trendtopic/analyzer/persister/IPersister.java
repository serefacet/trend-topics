package com.serefacet.bigdata.trendtopic.analyzer.persister;

import org.apache.spark.sql.Dataset;

/**
 * Persister
 * @param <T> type of dataset
 */
public interface IPersister<T> {
    /**
     * Persist the given dataset to the target datasource
     * @param input dataset
     */
    void persist(Dataset<T> input);
}
