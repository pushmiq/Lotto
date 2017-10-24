package com.ron.lotto.bl.strategies;

import com.ron.lotto.bl.Lottery;
import com.ron.lotto.dto.Pair;
import com.ron.lotto.dto.RuleData;
import com.ron.lotto.utils.StarPrinter;

import java.util.ArrayList;
import java.util.Collections;

public class Pairs implements IStrategy {

    private ArrayList<Pair> allPairs = null;
    /*
        1) define all possible pairs
        2) for each lottery add counter for pairs
        3) show list of pairs sorted


     */


    public Pairs() {
        allPairs = new ArrayList<>();
        buildPairs();
    }

    private void buildPairs() {
        for (int num1 = 1; num1 < 37; num1++) {
            for (int num2 = num1 + 1; num2 < 38; num2++) {
                Pair temp = new Pair(num1, num2);
                allPairs.add(temp);
            }
        }
    }

    public void CountPairs(Lottery lottery) {
        createPairs(lottery);
        Collections.sort(this.allPairs);
    }

    private void createPairs(Lottery lottery) {
        int[] nums = lottery.getNumbers();
        incPair(nums[0], nums[1]);
        incPair(nums[0], nums[2]);
        incPair(nums[0], nums[3]);
        incPair(nums[0], nums[4]);
        incPair(nums[0], nums[5]);

        incPair(nums[1], nums[2]);
        incPair(nums[1], nums[3]);
        incPair(nums[1], nums[4]);
        incPair(nums[1], nums[5]);

        incPair(nums[2], nums[3]);
        incPair(nums[2], nums[4]);
        incPair(nums[2], nums[5]);

        incPair(nums[3], nums[4]);
        incPair(nums[3], nums[5]);

        incPair(nums[4], nums[5]);
    }

    private void incPair(Integer x1, Integer x2) {
        //search pair
        String pairName = x1.toString() + "," + x2.toString();
        Pair pair = getPairByName(pairName);
        if (null != pair)
            pair.incPair();
        else
            System.out.println("incPair error");
    }

    private Pair getPairByName(String pairName) {
        for (int i = 0; i < this.allPairs.size(); i++) {
            Pair pair = allPairs.get(i);
            if (pair.toString().equals(pairName))
                return pair;
        }

        return null;
    }

    @Override
    public void show() {
        for (Pair pair : allPairs) {
            System.out.println(pair.toString() + " " + StarPrinter.getInstance().print(pair.getCount()));
        }
    }

    public ArrayList<Lottery> removePermutations(RuleData rd, ArrayList<Lottery> permutations) {
        //run over given lotteries and remove lotteries
        //return the subset list
        for (Lottery lot : permutations) {
            if (checkLottery(lot, rd)) {
                permutations.remove(lot);
            }
        }

        return permutations;
    }

    private boolean checkLottery(Lottery lottery, RuleData rd){
        return false;
    }
}
