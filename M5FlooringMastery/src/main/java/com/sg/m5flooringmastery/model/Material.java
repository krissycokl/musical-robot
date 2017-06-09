package com.sg.m5flooringmastery.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Material {
    
    String name;
    BigDecimal laborCost;
    BigDecimal materialCost;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getLaborCost() {
        return laborCost;
    }
    
    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost.setScale(2);
    }
    
    public BigDecimal getMaterialCost() {
        return materialCost;
    }
    
    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost.setScale(2);
    }
}
