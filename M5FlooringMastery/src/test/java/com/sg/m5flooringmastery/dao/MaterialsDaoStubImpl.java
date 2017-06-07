package com.sg.m5flooringmastery.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaterialsDaoStubImpl implements MaterialsDao {

    @Override
    public BigDecimal getLaborCostPerSqFt(String material) {
        return BigDecimal.ONE;
    }

    @Override
    public BigDecimal getMaterialCostPerSqFt(String material) {
        return BigDecimal.ONE;
    }

    @Override
    public List<String> getMaterialsList() {
        List<String> materials = new ArrayList<>();
        materials.add("Wood");
        return materials;
    }

}
