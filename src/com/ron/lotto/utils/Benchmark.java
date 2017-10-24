package com.ron.lotto.utils;

import sun.rmi.runtime.Log;

/**
 * Created by Ron on 10/04/2017.
 */
public class Benchmark {

    private static Benchmark instance = null;

    protected Benchmark() {
    }

    public static Benchmark getInstance() {
        if (instance == null) {
            instance = new Benchmark();
        }

        return instance;
    }

    public void takeTime(String operationName) {
        if (!Logger.getInstance().canTakeTime(operationName))
            return;

        long nowTime = System.nanoTime();
        Logger.getInstance().log(operationName, nowTime);
    }

    public long getTimeReading(String operation) {
        return Logger.getInstance().getTimeReading(operation);
    }

    public void printTimeReading(String operation) {
        if (Logger.getInstance().canTakeTime(operation))
            takeTime(operation);

        System.out.println("Operation: " + operation + " = " + getTimeReading(operation) + " ms.");
    }
}
