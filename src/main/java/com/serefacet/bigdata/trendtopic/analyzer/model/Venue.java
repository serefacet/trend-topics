package com.serefacet.bigdata.trendtopic.analyzer.model;

import java.io.Serializable;

/**
 * Venue entity in Meetup data
 */
public class Venue implements Serializable {

    private long venue_id;
    private String venue_name;
    private double lon;
    private double lat;

    public Venue() {

    }

    public Venue(long venue_id, String venue_name, double lon, double lat) {
        this.venue_id = venue_id;
        this.venue_name = venue_name;
        this.lon = lon;
        this.lat = lat;
    }

    public long getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(long venue_id) {
        this.venue_id = venue_id;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venue_id=" + venue_id +
                ", venue_name='" + venue_name + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
