package com.sg.m5flooringmastery.dao;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public interface MaterialsDao {
    public void load() throws FileNotFoundException;
    public BigDecimal getMaterialCostPerSqFt(String material);
    public BigDecimal getLaborCostPerSqFt(String material);
}
