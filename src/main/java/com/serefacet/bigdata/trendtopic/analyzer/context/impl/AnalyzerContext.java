package com.serefacet.bigdata.trendtopic.analyzer.context.impl;

import com.serefacet.bigdata.trendtopic.analyzer.config.IAnalyzerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.SparkConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import org.apache.spark.sql.SparkSession;

/**
 * AnalyzerContext
 *
 * This class holds the required context elements for every phase of the application.
 */
public class AnalyzerContext implements IAnalyzerContext {

    private final SparkSession sparkSession;
    private final IAnalyzerConfig config;

    public AnalyzerContext(IAnalyzerConfig config) {
        this.config = config;
        SparkConfig sparkConfig = config.getSparkConfig();
        this.sparkSession = SparkSession.builder()
                .appName(sparkConfig.getAppName())
                .config("spark.master", sparkConfig.getMaster())
                .config("spark.sql.shuffle.partitions", sparkConfig.getShufflePartitions())
                .config("spark.driver.extraJavaOptions", sparkConfig.getDriverExtraJavaOptions())
                .config("spark.executor.extraJavaOptions", sparkConfig.getExecutorExtraJavaOptions())
                .getOrCreate();
    }

    @Override
    public SparkSession getSparkSession() {
        return sparkSession;
    }

    @Override
    public IAnalyzerConfig getConfig() {
        return config;
    }
}
