package com.serefacet.bigdata.trendtopic.analyzer.model.dto;

import java.io.Serializable;

public class RankedDataDTO implements Serializable {

    private WindowDTO window;
    private String urlkey;
    private long count;
    private long rank;

    public RankedDataDTO(){

    }

    public WindowDTO getWindow() {
        return window;
    }

    public void setWindow(WindowDTO window) {
        this.window = window;
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "RankedDataDTO{" +
                "window=" + window +
                ", urlkey='" + urlkey + '\'' +
                ", count=" + count +
                ", rank=" + rank +
                '}';
    }
}
