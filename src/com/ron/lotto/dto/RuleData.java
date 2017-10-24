package com.ron.lotto.dto;

import java.util.ArrayList;

public class RuleData {

    private String ruleName;
    private String ruleType;
    private ArrayList<RuleProperty> props;

    public RuleData(){
        props = new ArrayList<>();
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public void addProperty(String propName, String propValue, String propType, String operator) {
        props.add(new RuleProperty(propName, propValue, propType, operator));
    }

    public ArrayList<RuleProperty> getProps() {
        return props;
    }
}
