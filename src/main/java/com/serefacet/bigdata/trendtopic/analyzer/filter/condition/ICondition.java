package com.serefacet.bigdata.trendtopic.analyzer.filter.condition;

import org.apache.spark.sql.Dataset;

public interface ICondition<T> {
    /**
     * Apply the particular condition to the given input and returns the filtered data
     * @param input data
     * @return filtered data
     */
    Dataset<T> apply(Dataset<T> input);


    /**
     * Instantiate Condition object from fully qualified class name.
     * @param condition
     * @return condition object
     */
    static <T> ICondition<T> instantiate(String condition) {
        try {
            return (ICondition<T>) Class.forName(condition).newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("A problem is occurred during instantiating filter conditions", ex);
        }
    }

}
