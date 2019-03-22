package com.serefacet.bigdata.trendtopic.analyzer.filter.impl;

import com.serefacet.bigdata.trendtopic.analyzer.config.impl.FilterConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.filter.IFilter;
import com.serefacet.bigdata.trendtopic.analyzer.filter.condition.ICondition;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import org.apache.spark.sql.Dataset;

/**
 * This trend topic filter applies filter conditions defined in the config.properties
 */
public class TrendTopicFilter implements IFilter<RsvpMessage> {

    private FilterConfig config;

    public TrendTopicFilter(IAnalyzerContext context) {
        this.config = context.getConfig().getFilterConfig();
    }

    @Override
    public Dataset<RsvpMessage> filter(Dataset<RsvpMessage> input) {
        for(ICondition<RsvpMessage> condition : config.getConditionList()) {
            input = condition.apply(input);
        }
        return input;
    }
}
