package com.serefacet.bigdata.trendtopic.analyzer.persister.impl;

import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.RankedDataDTO;
import com.serefacet.bigdata.trendtopic.analyzer.persister.IPersister;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SaveMode;

/**
 * Json persister
 */
public class JsonPersister implements IPersister<RankedDataDTO> {

    private final IAnalyzerContext context;

    public JsonPersister(IAnalyzerContext context) {
        this.context = context;
    }

    @Override
    public void persist(Dataset<RankedDataDTO> input) {
        input.write().format("json").mode(SaveMode.Overwrite).save(context.getConfig().getPersisterConfig().getDestination());
    }
}
