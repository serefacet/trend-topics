package com.serefacet.bigdata.trendtopic.analyzer.receiver;

import org.apache.spark.sql.Dataset;

/**
 * Receiver
 *
 * @param <T> the type of receiving data
 */
public interface IReceiver<T> {

    /**
     * Receive the data and returns as Dataset
     * @return dataset
     */
    Dataset<T> receive();
}
