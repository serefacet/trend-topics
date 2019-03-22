package com.serefacet.bigdata.trendtopic.analyzer.transformer;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/**
 * Transformer
 * @param <T> type of input dataset
 * @param <R> type of output dataset
 */
public interface ITransformer<T, R> {
    /**
     * Transformed the given dataset to intended dataset
     * @param input filtered dataset
     * @return transformed dataset
     */
    Dataset<R> transform(Dataset<T> input);
}
