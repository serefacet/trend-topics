package com.serefacet.bigdata.trendtopic.analyzer.aggregator.impl;

import com.serefacet.bigdata.trendtopic.analyzer.aggregator.IAggregator;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AggregatorConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.AggregatedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.window;

/**
 * TrendTopic aggregator is responsible for grouping the data with date and urlkey, then calculates the count.
 */
public class TrendTopicAggregator implements IAggregator<TransformedDataDTO, AggregatedDataDTO> {
    private AggregatorConfig config;

    public TrendTopicAggregator(IAnalyzerContext context) {
        this.config = context.getConfig().getAggregatorConfig();
    }

    @Override
    public Dataset<AggregatedDataDTO> aggregate(Dataset<TransformedDataDTO> input) {
        return input
                // Cube returns the sub-total of two-paired group counts under particular windows
                //cube("date", "urlkey")
                .groupBy(window(col("date"), config.getWindowSize(), config.getSlideDuration()), col("urlkey"))
                // Calculate the count of urlkey occurances.
                .count()
                .as(Encoders.bean(AggregatedDataDTO.class));
    }
}
