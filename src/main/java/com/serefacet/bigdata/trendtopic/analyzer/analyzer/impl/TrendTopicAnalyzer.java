package com.serefacet.bigdata.trendtopic.analyzer.analyzer.impl;

import com.serefacet.bigdata.trendtopic.analyzer.analyzer.IAnalyzer;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AnalyzerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.impl.AnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.RankedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.persister.IPersister;
import com.serefacet.bigdata.trendtopic.analyzer.persister.impl.JsonPersister;
import com.serefacet.bigdata.trendtopic.analyzer.processor.IProcessor;
import com.serefacet.bigdata.trendtopic.analyzer.processor.impl.TrendTopicProcessor;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.impl.TrendTopicJsonReceiver;
import org.apache.spark.sql.Dataset;

/**
 * Trend Topic Analyzer
 */
public class TrendTopicAnalyzer implements IAnalyzer<RankedDataDTO> {

    @Override
    public Dataset<RankedDataDTO> analyze(AnalyzerConfig config) {
        AnalyzerContext context = new AnalyzerContext(config);

        IReceiver<RsvpMessage> receiver = new TrendTopicJsonReceiver(context);
        IProcessor<RsvpMessage, RankedDataDTO> processor = new TrendTopicProcessor(context);
        IPersister<RankedDataDTO> persister = new JsonPersister(context);

        // Receive the data
        Dataset<RsvpMessage> receivedData = receiver.receive();

        // Process the data
        Dataset<RankedDataDTO> processedData = processor.process(receivedData);
        
        // Persist the data
        persister.persist(processedData);

        return processedData;
    }
}