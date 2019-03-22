package com.serefacet.bigdata.trendtopic.analyzer.transformer.impl;

import com.serefacet.bigdata.trendtopic.analyzer.TestingBase;
import com.serefacet.bigdata.trendtopic.analyzer.filter.IFilter;
import com.serefacet.bigdata.trendtopic.analyzer.filter.impl.TrendTopicFilter;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.impl.TrendTopicJsonReceiver;
import com.serefacet.bigdata.trendtopic.analyzer.transformer.ITransformer;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrendTopicTransformerTest extends TestingBase {

    @Test
    @DisplayName("Explode Topics from Group Data Test")
    void testTransform() {
        ITransformer<RsvpMessage, TransformedDataDTO> transformer = new TrendTopicTransformer();
        Dataset<TransformedDataDTO> transformedDataset = transformer.transform(generateTestDataset());

        assertEquals(4, transformedDataset.collectAsList().size());
    }
}
