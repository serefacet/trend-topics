package com.serefacet.bigdata.trendtopic.analyzer.aggregator.impl;

import com.serefacet.bigdata.trendtopic.analyzer.TestingBase;
import com.serefacet.bigdata.trendtopic.analyzer.aggregator.IAggregator;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.AggregatedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import org.apache.spark.sql.Dataset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrendTopicAggregatorTest extends TestingBase {

    @Test
    @DisplayName("Aggregate the Transformed Data Test")
    void testAggregator() {

        IAggregator<TransformedDataDTO, AggregatedDataDTO> aggregator = new TrendTopicAggregator(getTestingContext());
        Dataset<AggregatedDataDTO> aggregatedData = aggregator.aggregate(generateTransformedDataset());
        List<AggregatedDataDTO> dtos = aggregatedData.collectAsList();
        Optional<AggregatedDataDTO> aggregatedSparkDTO = dtos
                .stream()
                .filter((dto) -> "spark".equals(dto.getUrlkey()))
                .findFirst();

        assertEquals(2, aggregatedSparkDTO.get().getCount());

        Optional<AggregatedDataDTO> aggregatedFlinkDTO = dtos
                .stream()
                .filter((dto) -> "flink".equals(dto.getUrlkey()))
                .findFirst();

        assertEquals(1, aggregatedFlinkDTO.get().getCount());
    }


}
