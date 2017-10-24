package com.ron.lotto.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ron on 10/04/2017.
 */
public class Logger {
    private static Logger instance = null;
    private ArrayList<TimeOperation> log = null;
    private HashMap<String, Integer> operationStartMap;
    private HashMap<String, Integer> operationEndMap;

    protected Logger() {
        log = new ArrayList<>();
        operationStartMap = new HashMap<>();
        operationEndMap = new HashMap<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String operation, long time) {
        log.add(new TimeOperation(operation, time));
        if (operationStartMap.containsKey(operation)) {
            operationEndMap.put(operation, log.size() - 1);
        } else
            operationStartMap.put(operation, log.size() - 1);
    }

    public long getTimeReading(String operation) {
        if (operationStartMap.containsKey(operation) && operationEndMap.containsKey(operation)) {
            int startIndex = operationStartMap.get(operation);
            int endIndex = operationEndMap.get(operation);
            return log.get(startIndex).getTimeDiffInMs(log.get(endIndex));
        } else
            return -1;
    }

    public boolean canTakeTime(String operation) {
        if (!operationStartMap.containsKey(operation))
            return true;

        return  !operationEndMap.containsKey(operation);
    }
}
