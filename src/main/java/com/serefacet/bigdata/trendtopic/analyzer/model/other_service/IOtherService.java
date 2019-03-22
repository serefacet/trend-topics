package com.serefacet.bigdata.trendtopic.analyzer.model.other_service;

import java.io.Serializable;

/**
 * Other Service
 */
public interface IOtherService extends Serializable {
    /**
     * Returns the user identifier of this service
     * @return identifier
     */
    String getIdentifier();
}
