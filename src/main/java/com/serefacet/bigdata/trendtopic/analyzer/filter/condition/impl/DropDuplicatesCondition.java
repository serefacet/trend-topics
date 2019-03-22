package com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl;

import com.serefacet.bigdata.trendtopic.analyzer.filter.condition.ICondition;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import org.apache.spark.sql.Dataset;

/**
 * DropDuplicatesCondition
 *
 * This condition filters the duplicate rows in dataframe regarding writtenproperties.
 */
public class DropDuplicatesCondition implements ICondition<RsvpMessage> {
    @Override
    public Dataset<RsvpMessage> apply(Dataset<RsvpMessage> input) {
        return input.dropDuplicates("event", "group", "guests", "member", "response", "rsvp_id", "venue");
    }
}
