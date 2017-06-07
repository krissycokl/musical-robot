package com.sg.m5flooringmastery.dao;

import java.math.BigDecimal;
import java.util.List;

public interface MaterialsDao {
    public BigDecimal getMaterialCostPerSqFt(String material);
    public BigDecimal getLaborCostPerSqFt(String material);
    public List<String> getMaterialsList();
}
