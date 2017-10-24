package com.ron.lotto.bl;

import java.util.Arrays;

/**
 * Created by Ron on 25/03/2017.
 */
public class Lottery {

    private int numbers[] = new int[6];
    private int strong;
    private int sum;
    private int avg;

    public Lottery(int[] numbers,int strong){
        this(numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],strong);
    }

    public Lottery(int a, int b, int c, int d, int e, int f, int strong) {
        numbers[0] = a;
        numbers[1] = b;
        numbers[2] = c;
        numbers[3] = d;
        numbers[4] = e;
        numbers[5] = f;
        Arrays.sort(numbers);
        this.strong = strong;
        this.sum = CalcSum();
        this.avg = this.sum /6;
    }

    public int GetHigh() {
        return numbers[5];
    }

    public int GetLow() {
        return numbers[0];
    }

    public int GetStrong() {
        return this.strong;
    }

    private int CalcSum() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    public int GetSum() {
        return this.sum;
    }

    public int GetAvg() {
        return this.avg;
    }

    public int[] getNumbers(){
        return this.numbers;
    }

}
