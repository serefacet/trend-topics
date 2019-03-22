package com.serefacet.bigdata.trendtopic.analyzer.transformer.impl;

import com.serefacet.bigdata.trendtopic.analyzer.transformer.ITransformer;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;

import static org.apache.spark.sql.functions.*;

/**
 * Trend Topic Transformer
 */
public class TrendTopicTransformer implements ITransformer<RsvpMessage, TransformedDataDTO> {

    @Override
    public Dataset<TransformedDataDTO> transform(Dataset<RsvpMessage> input) {
        // Explode urlkey array in group_topics
        return input.withColumn("urlkey", explode(col("group.group_topics.urlkey")))
                .select(from_unixtime(col("mtime").divide(1000)).as("date"), col("urlkey"))
                .as(Encoders.bean(TransformedDataDTO.class));
    }
}
