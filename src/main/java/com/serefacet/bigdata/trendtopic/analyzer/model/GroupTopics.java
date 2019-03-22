package com.serefacet.bigdata.trendtopic.analyzer.model;

import java.io.Serializable;

/**
 * GroupTopics entity in Meetup data
 */
public class GroupTopics implements Serializable {
    private String urlkey;
    private String topic_name;

    public GroupTopics() {

    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    @Override
    public String toString() {
        return "GroupTopics{" +
                "urlkey='" + urlkey + '\'' +
                ", topic_name='" + topic_name + '\'' +
                '}';
    }
}
