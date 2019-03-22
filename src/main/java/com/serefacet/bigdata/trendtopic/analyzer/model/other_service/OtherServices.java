package com.serefacet.bigdata.trendtopic.analyzer.model.other_service;


import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.type.Facebook;
import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.type.Flickr;
import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.type.Linkedin;
import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.type.Tumblr;
import com.serefacet.bigdata.trendtopic.analyzer.model.other_service.type.Twitter;

import java.io.Serializable;

/**
 * Other Services Entity
 */
public class OtherServices implements Serializable {

    private Facebook facebook;
    private Flickr flickr;
    private Linkedin linkedin;
    private Tumblr tumblr;
    private Twitter twitter;

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public Flickr getFlickr() {
        return flickr;
    }

    public void setFlickr(Flickr flickr) {
        this.flickr = flickr;
    }

    public Linkedin getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(Linkedin linkedin) {
        this.linkedin = linkedin;
    }

    public Tumblr getTumblr() {
        return tumblr;
    }

    public void setTumblr(Tumblr tumblr) {
        this.tumblr = tumblr;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "OtherServices{" +
                "facebook=" + facebook +
                ", flickr=" + flickr +
                ", linkedin=" + linkedin +
                ", tumblr=" + tumblr +
                ", twitter=" + twitter +
                '}';
    }
}
