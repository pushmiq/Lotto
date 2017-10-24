package com.ron.lotto.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvRecord {

    private int lotteryNumber;
    private Date lotteryDate;
    private int numbers[] = new int[6];
    private int strong;
    private int numOfWinners;
    private int numOfDoubleLottoWinners;

    public CsvRecord(String csvLine) {
        String[] args = csvLine.split(",");
        this.lotteryNumber = Integer.parseInt(args[0].split("\"")[1]);
        DateFormat format = new SimpleDateFormat("dd/MM/yy");
        try {
            this.lotteryDate = format.parse(args[1].split("\"")[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.numbers[0] = Integer.parseInt(args[2].split("\"")[1]);
        this.numbers[1] = Integer.parseInt(args[3].split("\"")[1]);
        this.numbers[2] = Integer.parseInt(args[4].split("\"")[1]);
        this.numbers[3] = Integer.parseInt(args[5].split("\"")[1]);
        this.numbers[4] = Integer.parseInt(args[6].split("\"")[1]);
        this.numbers[5] = Integer.parseInt(args[7].split("\"")[1]);
        this.strong = Integer.parseInt(args[8].split("\"")[1]);
        this.numOfWinners = Integer.parseInt(args[9].split("\"")[1]);
        this.numOfDoubleLottoWinners = Integer.parseInt(args[10].split("\"")[1]);
    }

    public int LotteryNumber() {
        return this.lotteryNumber;
    }

    public Date LotteryDate() {
        return this.lotteryDate;
    }

    public int[] GetLotteryNumbers() {
        return this.numbers;
    }

    public int GetStrongNumber() {
        return this.strong;
    }

    public int GetNumOfWinners() {
        return this.numOfWinners;
    }

    public int GetDoubleLottoWinners() {
        return this.numOfDoubleLottoWinners;
    }
}


