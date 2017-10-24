package com.ron.lotto.bl;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ronal on 4/11/2017.
 */
public class LogicManager {

    // maybe divide to several ArrayList with map for better performance search
    //arraylist of all permutations starts with 1 etc...
    private ArrayList<Lottery> allPermutationsLotteries = null;

    public LogicManager() {
        allPermutationsLotteries = new ArrayList<>();
    }

    public void calcAllPossiblePermutations() {
        for (int a = 1; a < 38; a++) {
            for (int b = a + 1; b < 38; b++) {
                for (int c = b + 1; c < 38; c++) {
                    for (int d = c + 1; d < 38; d++) {
                        for (int e = d + 1; e < 38; e++) {
                            for (int f = e + 1; f < 38; f++) {
                                //if (isValidLottery(a, b, c, d, e, f)) {
                                allPermutationsLotteries.add(new Lottery(a, b, c, d, e, f, 0));
                                //}
                            }
                        }
                    }
                }
            }
        }

    }

    public int getPermCount() {
        return this.allPermutationsLotteries.size();
    }

    public ArrayList<Lottery> getAllPermutationsLotteries(){
        return this.allPermutationsLotteries;
    }


}
