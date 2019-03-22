package com.serefacet.bigdata.trendtopic.analyzer.model.other_service;

/**
 * Abstract Other Service
 */
public class AbstractOtherService implements IOtherService {
    public String identifier;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier of user for this service.
     * @param identifier user identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "AbstractOtherService{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
