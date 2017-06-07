package com.sg.m5flooringmastery.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxesDaoStubImpl implements TaxesDao {

    @Override
    public BigDecimal getRate(String state) {
        return new BigDecimal("5");
    }

    @Override
    public List<String> getStatesList() {
        List<String> materials = new ArrayList<>();
        materials.add("IL");
        return materials;
    }

}