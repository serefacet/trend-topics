package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.serefacet.bigdata.trendtopic.analyzer.config.IAnalyzerConfig;
import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConcurrentMapConfiguration;
import com.netflix.config.ConfigurationManager;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

/**
 * AnalyzerConfig
 */
public class AnalyzerConfig implements IAnalyzerConfig {
    private final SparkConfig sparkConfig;
    private final ReceiverConfig receiverConfig;
    private final FilterConfig filterConfig;
    private final AggregatorConfig aggregatorConfig;
    private final RankerConfig rankerConfig;
    private final PersisterConfig persisterConfig;

    public AnalyzerConfig() {
        initialize();
        this.sparkConfig = new SparkConfig();
        this.receiverConfig = new ReceiverConfig();
        this.aggregatorConfig = new AggregatorConfig();
        this.filterConfig = new FilterConfig();
        this.rankerConfig = new RankerConfig();
        this.persisterConfig = new PersisterConfig();
    }

    private void initialize() {
        ConcurrentMapConfiguration configFromPropertiesFile =
                new ConcurrentMapConfiguration(new PropertiesConfiguration());
        // configuration from system properties
        ConcurrentMapConfiguration configFromSystemProperties =
                new ConcurrentMapConfiguration(new SystemConfiguration());

        // system properties override properties file
        ConcurrentCompositeConfiguration finalConfig = new ConcurrentCompositeConfiguration();
        finalConfig.addConfiguration(configFromSystemProperties, "systemConfig");
        finalConfig.addConfiguration(configFromPropertiesFile, "fileConfig");

        // install with ConfigurationManager so that finalConfig
        // becomes the source of dynamic properties
        ConfigurationManager.install(finalConfig);
    }

    @Override
    public SparkConfig getSparkConfig() {
        return sparkConfig;
    }

    @Override
    public ReceiverConfig getReceiverConfig() {
        return receiverConfig;
    }

    @Override
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public AggregatorConfig getAggregatorConfig() {
        return aggregatorConfig;
    }

    @Override
    public RankerConfig getRankerConfig() {
        return rankerConfig;
    }

    @Override
    public PersisterConfig getPersisterConfig() {
        return persisterConfig;
    }
}
