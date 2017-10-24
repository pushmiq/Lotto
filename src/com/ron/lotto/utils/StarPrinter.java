package com.ron.lotto.utils;

public class StarPrinter {
    private static StarPrinter instance = null;

    protected StarPrinter() {
    }

    public static StarPrinter getInstance() {
        if (instance == null) {
            instance = new StarPrinter();
        }

        return instance;
    }

    public String print(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("*");
        }
        sb.append("(" + count + ")");

        return sb.toString();
    }
}
