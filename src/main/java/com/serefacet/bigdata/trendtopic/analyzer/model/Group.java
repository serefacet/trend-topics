package com.serefacet.bigdata.trendtopic.analyzer.model;

import java.io.Serializable;
import java.util.List;

/**
 * Group entity in Meetup data
 */
public class Group implements Serializable {
    private long group_id;
    private String group_name;
    private String group_city;
    private String group_state;
    private String group_country;
    private double group_lon;
    private double group_lat;
    private String group_urlname;
    private List<GroupTopics> group_topics;

    public Group() {

    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_city() {
        return group_city;
    }

    public void setGroup_city(String group_city) {
        this.group_city = group_city;
    }

    public String getGroup_state() {
        return group_state;
    }

    public void setGroup_state(String group_state) {
        this.group_state = group_state;
    }

    public String getGroup_country() {
        return group_country;
    }

    public void setGroup_country(String group_country) {
        this.group_country = group_country;
    }

    public double getGroup_lon() {
        return group_lon;
    }

    public void setGroup_lon(double group_lon) {
        this.group_lon = group_lon;
    }

    public double getGroup_lat() {
        return group_lat;
    }

    public void setGroup_lat(double group_lat) {
        this.group_lat = group_lat;
    }

    public String getGroup_urlname() {
        return group_urlname;
    }

    public void setGroup_urlname(String group_urlname) {
        this.group_urlname = group_urlname;
    }

    public List<GroupTopics> getGroup_topics() {
        return group_topics;
    }

    public void setGroup_topics(List<GroupTopics> group_topics) {
        this.group_topics = group_topics;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_id=" + group_id +
                ", group_name='" + group_name + '\'' +
                ", group_city='" + group_city + '\'' +
                ", group_state='" + group_state + '\'' +
                ", group_country='" + group_country + '\'' +
                ", group_lon=" + group_lon +
                ", group_lat=" + group_lat +
                ", group_urlname='" + group_urlname + '\'' +
                ", group_topics=" + group_topics +
                '}';
    }
}
