package com.sg.m5flooringmastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxesDaoFileImpl implements TaxesDao {

    Map<String, BigDecimal> stateTaxRates = new HashMap<>();
    
    public TaxesDaoFileImpl() throws FileNotFoundException{
        load();
    }
    
    @Override
    public BigDecimal getRate(String state) {
        return stateTaxRates.get(state);
    }

    @Override
    public List<String> getStatesList() {
        return stateTaxRates.keySet().stream().collect(Collectors.toList());
    }

    public void load() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Taxes.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            String[] stateInfo = sc.nextLine().split(",");
            String state = stateInfo[0];
            BigDecimal taxRate = new BigDecimal(stateInfo[1]).divide(new BigDecimal("100"));
            
            stateTaxRates.put(state, taxRate);
        }
        sc.close();
    }
    
}
