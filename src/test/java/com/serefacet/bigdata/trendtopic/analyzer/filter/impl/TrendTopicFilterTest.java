package com.serefacet.bigdata.trendtopic.analyzer.filter.impl;

import com.serefacet.bigdata.trendtopic.analyzer.TestingBase;
import com.serefacet.bigdata.trendtopic.analyzer.filter.IFilter;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.IReceiver;
import com.serefacet.bigdata.trendtopic.analyzer.receiver.impl.TrendTopicJsonReceiver;
import org.apache.spark.sql.Dataset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrendTopicFilterTest extends TestingBase {

    @Test
    @DisplayName("Filter Trend Topic Data Test")
    void testFilter() {
        IFilter<RsvpMessage> filter = new TrendTopicFilter(getTestingContext());

        Dataset<RsvpMessage> filteredData = filter.filter(generateTestDataset());

        List<RsvpMessage> rsvpMessages = filteredData.collectAsList();

        assertEquals(3, rsvpMessages.size());

        RsvpMessage rsvpMessage = rsvpMessages.stream()
                .filter(rsvp -> rsvp.getRsvp_id() == TEST_RSVP_ID)
                .findFirst()
                .get();

        assertEquals(1489925470960L, rsvpMessage.getMtime());
        assertEquals(0, rsvpMessage.getGuests());
        assertEquals("yes", rsvpMessage.getResponse());
        assertEquals("test_event", rsvpMessage.getEvent().getEvent_id());
        assertEquals("Ankara", rsvpMessage.getGroup().getGroup_city());
        assertEquals("Technology Evangelists", rsvpMessage.getGroup().getGroup_name());
    }
}
