package com.serefacet.bigdata.trendtopic.analyzer;

import com.serefacet.bigdata.trendtopic.analyzer.analyzer.IAnalyzer;
import com.serefacet.bigdata.trendtopic.analyzer.analyzer.impl.TrendTopicAnalyzer;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AnalyzerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.RankedDataDTO;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

/**
 * TrendTopic Application
 */
public class TrendTopicApplication {

    /**
     * Main thread
     * @param args program arguments
     */
    public static void main(String[] args) {
        new TrendTopicAnalyzer().analyze(new AnalyzerConfig());
    }

}
