package com.serefacet.bigdata.trendtopic.analyzer.receiver.impl;

import com.serefacet.bigdata.trendtopic.analyzer.TestingBase;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import org.apache.spark.sql.Dataset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrendTopicJsonReceiverTest extends TestingBase {

    @Test
    @DisplayName("Receive Meetup RSVP Messages from JSON file Test")
    void testReceive() {
        IReceiver<RsvpMessage> receiver = new TrendTopicJsonReceiver(getTestingContext());
        Dataset<RsvpMessage> receivedData = receiver.receive();
        assertEquals(3, receivedData.count());
    }
}
