package com.serefacet.bigdata.trendtopic.analyzer.receiver.impl;

import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.from_json;

/**
 * TrendTopicKafkaReceiver
 */
public class TrendTopicKafkaReceiver implements IReceiver<RsvpMessage> {
    private final IAnalyzerContext context;

    public TrendTopicKafkaReceiver(IAnalyzerContext context) {
        this.context = context;
    }

    @Override
    public Dataset<RsvpMessage> receive() {
//        Encoder<RsvpMessage> encoder = Encoders.bean(RsvpMessage.class);
//        Dataset<Row> load = context.getSparkSession()
//                .read()
//                .format("kafka")
//                .option("kafka.bootstrap.servers", context.getConfig().getReceiverConfig().getKafkaConfig().getBootstrapServers())
//                .option("subscribe", context.getConfig().getReceiverConfig().getKafkaConfig().getTopicName())
//                .load();
//
//        Dataset<Row> json = load.selectExpr("CAST(value AS STRING) as json")
//                .select(from_json(col("json"), encoder.schema()));
        throw new UnsupportedOperationException("The kafka receiver of meetup rsvp data implementation is not finished!");
    }
}
