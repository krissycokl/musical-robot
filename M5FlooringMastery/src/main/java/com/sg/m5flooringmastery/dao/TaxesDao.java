package com.sg.m5flooringmastery.dao;

import java.math.BigDecimal;
import java.util.List;

public interface TaxesDao {
    public BigDecimal getRate(String state);
    public List<String> getStatesList();
}
