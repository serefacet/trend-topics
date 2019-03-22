package com.serefacet.bigdata.trendtopic.analyzer.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class WindowDTO implements Serializable {
    private Timestamp start;
    private Timestamp end;

    public WindowDTO() {

    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "WindowDTO{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
