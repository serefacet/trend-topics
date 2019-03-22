package com.serefacet.bigdata.trendtopic.analyzer.model.dto;

import java.io.Serializable;

public class AggregatedDataDTO implements Serializable {

    private WindowDTO window;
    private String urlkey;
    private long count;

    public AggregatedDataDTO(){

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

    @Override
    public String toString() {
        return "AggregatedDataDTO{" +
                "window=" + window +
                ", urlkey='" + urlkey + '\'' +
                ", count=" + count +
                '}';
    }
}
