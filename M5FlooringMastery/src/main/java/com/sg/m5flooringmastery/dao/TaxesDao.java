package com.sg.m5flooringmastery.dao;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public interface TaxesDao {
    public void load() throws FileNotFoundException;
    public BigDecimal getRate(String state);
}
