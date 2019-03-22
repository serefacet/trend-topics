package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.netflix.config.DynamicPropertyFactory;

public class SparkConfig {

    private final String appName;
    private final String master;
    private final int shufflePartitions;
    private final String driverExtraJavaOptions;
    private final String executorExtraJavaOptions;

    public SparkConfig() {
        DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();
        master = propertyFactory.getStringProperty("spark.master", "local[2]").get();
        appName = propertyFactory.getStringProperty("spark.appName", "TrendTopic").get();
        shufflePartitions = propertyFactory.getIntProperty("spark.sql.shuffle.partitions", 3).get();
        driverExtraJavaOptions = propertyFactory.getStringProperty("spark.driver.extraJavaOptions", "log4j.configuration=log4j.property").get();
        executorExtraJavaOptions = propertyFactory.getStringProperty("spark.executor.extraJavaOptions", "log4j.configuration=log4j.property").get();
    }

    /**
     * Returns Spark application name
     * @return the spark application name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Returns the spark master
     * @return spark master
     */
    public String getMaster() {
        return master;
    }

    /**
     * Returns the spark shuffle partitions.
     * @return spark shuffle partitions
     */
    public int getShufflePartitions() {
        return shufflePartitions;
    }

    /**
     * Returns spark driver extra java options
     * @return driver extra java options
     */
    public String getDriverExtraJavaOptions() {
        return driverExtraJavaOptions;
    }

    /**
     * Returns the executor extra java options
     * @return executor extra java options
     */
    public String getExecutorExtraJavaOptions() {
        return executorExtraJavaOptions;
    }
}
