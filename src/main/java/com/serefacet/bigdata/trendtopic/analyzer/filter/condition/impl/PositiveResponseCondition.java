package com.serefacet.bigdata.trendtopic.analyzer.filter.condition.impl;

import com.serefacet.bigdata.trendtopic.analyzer.filter.condition.ICondition;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.col;

/**
 * This condition filters the rows which has "yes" response.
 */
public class PositiveResponseCondition implements ICondition<Row> {

    @Override
    public Dataset<Row> apply(Dataset<Row> input) {
        return input.filter(col("response").equalTo("yes"));
    }
}
