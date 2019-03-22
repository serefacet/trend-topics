package com.serefacet.bigdata.trendtopic.analyzer.model.dto;

import java.io.Serializable;
public class TransformedDataDTO implements Serializable {

    private String date;
    private String urlkey;

    public TransformedDataDTO(){

    }

    public TransformedDataDTO(String date, String urlkey) {
        this.date = date;
        this.urlkey = urlkey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    @Override
    public String toString() {
        return "TransformedDataDTO{" +
                "date='" + date + '\'' +
                ", urlkey='" + urlkey + '\'' +
                '}';
    }
}
