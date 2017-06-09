package com.sg.m5flooringmastery.model;

import java.math.BigDecimal;

public class State {
    String name;
    BigDecimal taxRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
