package com.serefacet.bigdata.trendtopic.analyzer.processor;

import org.apache.spark.sql.Dataset;

/**
 * Processor
 * @param <T> Input dataset type
 * @param <R> Output dataset type
 */
public interface IProcessor<T, R> {
    /**
     * Process the input data with filter, transformer, aggregator, ranker phases.
     * @param input dataset
     * @return processed dataset
     */
    Dataset<R> process(Dataset<T> input);
}
