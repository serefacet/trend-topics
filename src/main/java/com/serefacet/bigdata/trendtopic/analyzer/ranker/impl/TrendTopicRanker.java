package com.serefacet.bigdata.trendtopic.analyzer.ranker.impl;

import com.serefacet.bigdata.trendtopic.analyzer.config.impl.RankerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.AggregatedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.RankedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.ranker.IRanker;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.expressions.Window;

import static org.apache.spark.sql.functions.col;

/**
 * TrendTopicRanker
 */
public class TrendTopicRanker implements IRanker<AggregatedDataDTO, RankedDataDTO> {

    private final RankerConfig config;

    public TrendTopicRanker(IAnalyzerContext context) {
        this.config = context.getConfig().getRankerConfig();
    }

    @Override
    public Dataset<RankedDataDTO> rank(Dataset<AggregatedDataDTO> input) {
        return input
                // Rank the urlkey count
                .withColumn("rank", org.apache.spark.sql.functions.percent_rank().over(Window.partitionBy("window").orderBy(col("count").asc())))
                // Percentage should be higher than 0
                .filter(col("rank").gt(0))
                // Filter the rank according to user input nTop
                .filter(col("rank").leq(config.getTopRecords()))
                // Order the result ascending with date
                .orderBy(col("rank").desc(), col("window").asc())
                .as(Encoders.bean(RankedDataDTO.class));
    }
}
