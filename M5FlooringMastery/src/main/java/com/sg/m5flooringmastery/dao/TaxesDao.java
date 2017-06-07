package com.sg.m5flooringmastery.dao;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public interface TaxesDao {
    public void load() throws FileNotFoundException;
    public BigDecimal getRate(String state);
    public List<String> getStatesList();
}
