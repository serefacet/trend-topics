package com.serefacet.bigdata.trendtopic.analyzer.model;

import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.OtherServices;

import java.io.Serializable;

/**
 * Member entity in Meetup data
 */
public class Member implements Serializable {
    private long member_id;
    private String member_name;
    private String photo;
    private OtherServices other_services;

    public Member() {

    }

    public Member(long member_id, String member_name, String photo, OtherServices other_services) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.photo = photo;
        this.other_services = other_services;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public OtherServices getOther_services() {
        return other_services;
    }

    public void setOther_services(OtherServices other_services) {
        this.other_services = other_services;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", member_name='" + member_name + '\'' +
                ", photo='" + photo + '\'' +
                ", other_services=" + other_services +
                '}';
    }
}
