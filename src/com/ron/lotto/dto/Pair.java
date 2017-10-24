package com.ron.lotto.dto;

public class Pair implements Comparable{

    private int first;
    private int second;
    private int counter = 0;

    public Pair(int a, int b) {
        if (a < b) {
            this.first = a;
            this.second = b;
        } else {
            this.first = b;
            this.second = a;
        }
    }

    public void incPair(){
        counter++;
    }

    public int getCount(){
        return this.counter;
    }

    public int first() {
        return this.first;
    }

    public int second() {
        return this.second;
    }

    public String toString() {
        return Integer.toString(first) + "," + Integer.toString(second);
    }

    @Override
    public int compareTo(Object o) {
        if (this.counter == ((Pair) o).counter)
            return 0;
        else if ((this.counter) > ((Pair) o).counter)
            return -1;
        else
            return 1;
    }
}
