package com.serefacet.bigdata.trendtopic.analyzer.model;

import java.io.Serializable;

/**
 * Event entity in Meetup data
 */
public class Event implements Serializable {
    private String event_id;
    private String event_name;
    private String event_url;
    private long time;

    public Event() {

    }

    public Event(String event_id, String event_name, String event_url, long time) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_url = event_url;
        this.time = time;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_url() {
        return event_url;
    }

    public void setEvent_url(String event_url) {
        this.event_url = event_url;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", event_name='" + event_name + '\'' +
                ", event_url='" + event_url + '\'' +
                ", time=" + time +
                '}';
    }
}
