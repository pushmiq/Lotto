package com.ron.lotto.bl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ron on 25/03/2017.
 */
public class LotteryManager {

    private ArrayList<Lottery> lotteries = null;

    public LotteryManager() throws IOException {
        lotteries = new ArrayList<Lottery>();
        ReadFromCsv();
    }

    public void Add(Lottery lot) {
        lotteries.add(lot);
    }

    public ArrayList<Lottery> getAllLotteries() {
        return lotteries;
    }

    public ArrayList<Lottery> getLotteries(int lotCount) {
        lotCount = (lotCount < lotteries.size()) ? lotCount : lotteries.size();
        ArrayList<Lottery> result = new ArrayList<>();
        for (int i = lotteries.size() - lotCount; i < lotteries.size(); i++) {
            result.add(lotteries.get(i));
        }

        return result;
    }

    private void ReadFromCsv() throws IOException {
        String csvFile = System.getProperty("user.dir") + "/resources/Lotto.csv";
        String line = "";
        int lineCounter = 0;

        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {
            lineCounter++;
            if (lineCounter == 1)
                continue;

            CsvRecord csvLine = new CsvRecord(line);
            if (CheckNumbers(csvLine))
                this.Add(new Lottery(csvLine.GetLotteryNumbers(), csvLine.GetStrongNumber()));
            else
                break;
        }
    }

    private boolean CheckNumbers(CsvRecord line) {
        for (int number : line.GetLotteryNumbers()) {
            if (line.GetStrongNumber() > 7)
                return false;
            if (number > 37)
                return false;
        }

        return true;
    }
}
