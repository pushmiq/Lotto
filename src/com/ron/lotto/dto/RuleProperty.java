package com.ron.lotto.dto;

public class RuleProperty {

    private String propName;
    private String propValue;
    private String propDataType;
    private String operator;

    public RuleProperty() {

    }

    public RuleProperty(String name, String value, String dataType, String operator) {
        this.propName = name;
        this.propValue = value;
        this.propDataType = dataType;
        this.setOperator(operator);
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getPropType() {
        return propDataType;
    }

    public void setPropType(String propType) {
        this.propDataType = propType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
