package com.serefacet.bigdata.trendtopic.analyzer.receiver.impl;

import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;

/**
 * TrendTopicJsonReceiver
 */
public class TrendTopicJsonReceiver implements IReceiver<RsvpMessage> {
    private final IAnalyzerContext context;

    public TrendTopicJsonReceiver(IAnalyzerContext context) {
        this.context = context;
    }

    @Override
    public Dataset<RsvpMessage> receive() {
        Encoder<RsvpMessage> encoder = Encoders.bean(RsvpMessage.class);
        return context.getSparkSession()
                .read()
                .schema(encoder.schema())
                .format("json")
                .load(context.getConfig().getReceiverConfig().getJsonConfig().getPath())
                .as(encoder);
    }
}
