package com.ron.lotto;

import com.ron.lotto.bl.LogicManager;
import com.ron.lotto.bl.Lottery;
import com.ron.lotto.bl.LotteryManager;
import com.ron.lotto.bl.strategies.Pairs;
import com.ron.lotto.dto.RuleData;
import com.ron.lotto.utils.Benchmark;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Benchmark.getInstance().takeTime("startApp");
        LotteryManager lotManager = new LotteryManager();
        LogicManager logicManager = new LogicManager();
        logicManager.calcAllPossiblePermutations();



        Benchmark.getInstance().takeTime("countPairs");
        Pairs pairs = new Pairs();
        for (Lottery lot : lotManager.getAllLotteries()) {
            pairs.CountPairs(lot);
        }

        //ArrayList<Lottery> result = lm.getLotteries(10);

        pairs.show();

        RuleData rd = new RuleData();
        rd.setRuleName("pairs above 20");
        rd.setRuleType("pairs");
        rd.addProperty("appearance", "20", "number", "Above");

        pairs.removePermutations(rd,logicManager.getAllPermutationsLotteries());
        Benchmark.getInstance().printTimeReading("countPairs");
        Benchmark.getInstance().printTimeReading("startApp");
    }
}
