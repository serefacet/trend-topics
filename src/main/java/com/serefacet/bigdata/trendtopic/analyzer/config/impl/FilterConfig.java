package com.serefacet.bigdata.trendtopic.analyzer.config.impl;

import com.serefacet.bigdata.trendtopic.analyzer.filter.condition.ICondition;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.netflix.config.DynamicPropertyFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FilterConfig
 */
public class FilterConfig {

    private final List<ICondition<RsvpMessage>> conditionList;

    public FilterConfig() {
        String[] conditionClasses = DynamicPropertyFactory.getInstance()
                .getStringProperty("filter.conditions",
                        "com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.DropDuplicatesCondition,com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl.PositiveResponseCondition")
                .get().split(",");

        conditionList = Arrays.stream(conditionClasses)
                .map(ICondition::<RsvpMessage>instantiate)
                .collect(Collectors.toList());
    }

    /**
     * Return the condition list of filter. These filter conditions are applied to input data during filter phase.
     *
     * @return filter condition list
     */
    public List<ICondition<RsvpMessage>> getConditionList() {
        return conditionList;
    }

}
