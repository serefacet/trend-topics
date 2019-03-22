package com.serefacet.bigdata.trendtopic.analyzer.processor.impl;

import com.serefacet.bigdata.trendtopic.analyzer.aggregator.IAggregator;
import com.serefacet.bigdata.trendtopic.analyzer.aggregator.impl.TrendTopicAggregator;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.filter.IFilter;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.AggregatedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.RankedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.ranker.IRanker;
import com.serefacet.bigdata.trendtopic.analyzer.ranker.impl.TrendTopicRanker;
import com.serefacet.bigdata.trendtopic.analyzer.transformer.ITransformer;
import com.serefacet.bigdata.trendtopic.analyzer.transformer.impl.TrendTopicTransformer;
import com.serefacet.bigdata.trendtopic.analyzer.filter.impl.TrendTopicFilter;
import com.serefacet.bigdata.trendtopic.analyzer.processor.IProcessor;
import org.apache.spark.sql.Dataset;

public class TrendTopicProcessor implements IProcessor<RsvpMessage, RankedDataDTO> {

    private final IAnalyzerContext context;

    public TrendTopicProcessor(IAnalyzerContext context) {
        this.context = context;
    }

    @Override
    public Dataset<RankedDataDTO> process(Dataset<RsvpMessage> input) {
        IFilter<RsvpMessage> filter = new TrendTopicFilter(context);
        ITransformer<RsvpMessage, TransformedDataDTO> transformer = new TrendTopicTransformer();
        IAggregator<TransformedDataDTO, AggregatedDataDTO> aggregator = new TrendTopicAggregator(context);
        IRanker<AggregatedDataDTO, RankedDataDTO> ranker = new TrendTopicRanker(context);

        Dataset<RsvpMessage> filteredMessages = filter.filter(input);
        Dataset<TransformedDataDTO> transformedData = transformer.transform(filteredMessages);
        Dataset<AggregatedDataDTO> aggregatedData = aggregator.aggregate(transformedData);
        Dataset<RankedDataDTO> rankedData = ranker.rank(aggregatedData);

        return rankedData;
    }
}
