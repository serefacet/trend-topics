package com.serefacet.bigdata.trendtopic.analyzer;

import com.serefacet.bigdata.trendtopic.analyzer.config.IAnalyzerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.config.impl.AnalyzerConfig;
import com.serefacet.bigdata.trendtopic.analyzer.context.IAnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.context.impl.AnalyzerContext;
import com.serefacet.bigdata.trendtopic.analyzer.model.Event;
import com.serefacet.bigdata.trendtopic.analyzer.model.Group;
import com.serefacet.bigdata.trendtopic.analyzer.model.GroupTopics;
import com.serefacet.bigdata.trendtopic.analyzer.model.Member;
import com.serefacet.bigdata.trendtopic.analyzer.model.RsvpMessage;
import com.serefacet.bigdata.trendtopic.analyzer.model.Venue;
import com.serefacet.bigdata.trendtopic.analyzer.model.dto.TransformedDataDTO;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestingBase {
    protected static final long TEST_RSVP_ID = 19071907L;
    private static IAnalyzerConfig analyzerConfig = new AnalyzerConfig();
    private static IAnalyzerContext testingContext = new AnalyzerContext(analyzerConfig);

    public IAnalyzerContext getTestingContext() {
        return testingContext;
    }

    protected static RsvpMessage generateDummyRsvpMessage(long id, long mtime, String response, String topicName, String groupName) {
        RsvpMessage rsvp = new RsvpMessage();

        Venue venue = new Venue(23779799, "TOBB ETU University", 0, 0);
        rsvp.setVenue(venue);

        rsvp.setVisibility("public");
        rsvp.setResponse(response);
        rsvp.setGuests(0);

        Member member = new Member(id, "Seref Acet", "http://meetup.com/test.jpeg", null);
        rsvp.setMember(member);
        rsvp.setRsvp_id(id);
        rsvp.setMtime(mtime);
        Event event = new Event("test_event", "How to pass an interview", "https://www.meetup.com/bigdata", 1491613200000L);
        rsvp.setEvent(event);

        Group group = new Group();
        group.setGroup_id(16585312);
        group.setGroup_name(groupName);
        group.setGroup_city("Ankara");
        group.setGroup_country("Turkey");

        List<GroupTopics> topicsList = new ArrayList<>();
        GroupTopics groupTopics = new GroupTopics();
        groupTopics.setTopic_name(topicName);
        groupTopics.setUrlkey(topicName);
        topicsList.add(groupTopics);
        group.setGroup_topics(topicsList);
        rsvp.setGroup(group);

        return rsvp;
    }

    private static List<RsvpMessage> generateDummyRsvpMessageList() {
        RsvpMessage rsvpMessage = generateDummyRsvpMessage(TEST_RSVP_ID, 1489925470960L, "yes", "interview", "Technology Evangelists");
        RsvpMessage rsvpMessage1 = generateDummyRsvpMessage(TEST_RSVP_ID + 1, 1489925470961L, "yes", "bigdata", "Big Data Developers");
        RsvpMessage rsvpMessage2 = generateDummyRsvpMessage(TEST_RSVP_ID + 2, 1489925470962L, "yes", "spark", "Databricks");
        RsvpMessage rsvpMessage3 = generateDummyRsvpMessage(TEST_RSVP_ID + 3, 1489925470963L, "no", "flink", "Apache");

        return Arrays.asList(rsvpMessage, rsvpMessage1, rsvpMessage2, rsvpMessage3);
    }

    protected static Dataset<RsvpMessage> generateTestDataset() {
        return testingContext.getSparkSession().createDataset(generateDummyRsvpMessageList(), Encoders.bean(RsvpMessage.class));
    }

    protected static Dataset<TransformedDataDTO> generateTransformedDataset() {
        TransformedDataDTO transformedDataDTO = new TransformedDataDTO("2017-02-09T22:30:00.000+03:00", "spark");
        TransformedDataDTO transformedDataDTO1 = new TransformedDataDTO("2017-02-09T22:30:00.000+03:00", "spark");
        TransformedDataDTO transformedDataDTO2 = new TransformedDataDTO("2017-02-09T22:45:00.000+03:00", "flink");
        TransformedDataDTO transformedDataDTO3 = new TransformedDataDTO("2017-02-09T22:45:00.000+03:00", "kafka");

        List<TransformedDataDTO> transformedDataList = Arrays.asList(transformedDataDTO, transformedDataDTO1, transformedDataDTO2, transformedDataDTO3);

        return testingContext.getSparkSession().createDataset(transformedDataList, Encoders.bean(TransformedDataDTO.class));
    }
}
