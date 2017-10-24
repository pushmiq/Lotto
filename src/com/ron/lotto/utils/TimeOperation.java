package com.ron.lotto.utils;

/**
 * Created by ronal on 4/11/2017.
 */
public class TimeOperation {
    private long time;
    private String operation = "";

    public TimeOperation(String operation, long time) {
        this.time = time;
        this.operation = operation;
    }

    public String name() {
        return this.operation;
    }

    public long getTime() {
        return this.time;
    }

    public long getTimeDiffInMs(TimeOperation to) {
        return Math.abs((this.time - to.getTime()) / 1000000);
    }
}
