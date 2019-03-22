package com.serefacet.bigdata.trendtopic.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * RsvpMessage entity in Meetup data
 */
public class RsvpMessage implements Serializable {

    private Venue venue;
    private String visibility;
    private String response;
    private long guests;
    private Member member;
    private long rsvp_id;
    private long mtime;
    private Event event;
    private Group group;

    public RsvpMessage() {

    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public long getGuests() {
        return guests;
    }

    public void setGuests(long guests) {
        this.guests = guests;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getRsvp_id() {
        return rsvp_id;
    }

    public void setRsvp_id(long rsvp_id) {
        this.rsvp_id = rsvp_id;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "RsvpMessage{" +
                "venue=" + venue +
                ", visibility='" + visibility + '\'' +
                ", response='" + response + '\'' +
                ", guests=" + guests +
                ", member=" + member +
                ", rsvp_id=" + rsvp_id +
                ", mtime=" + mtime +
                ", event=" + event +
                ", group=" + group +
                '}';
    }
}
