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

public class MaterialsDaoFileImpl implements MaterialsDao {

    Map<String, BigDecimal[]> materials = new HashMap<>();
    
    public MaterialsDaoFileImpl() throws FileNotFoundException{
        load();
    }
    
    @Override
    public BigDecimal getMaterialCostPerSqFt(String material) {
        return materials.get(material)[0];
    }
    
    @Override
    public BigDecimal getLaborCostPerSqFt(String material) {
        return materials.get(material)[1];
    }

    @Override
    public List<String> getMaterialsList() {
        return materials.keySet().stream().collect(Collectors.toList());
    }
    
    public void load() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Products.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            String[] materialInfo = sc.nextLine().split(",");
            String material = materialInfo[0];
            BigDecimal costPerSqFt = new BigDecimal(materialInfo[1]);
            BigDecimal laborCostPerSqFt = new BigDecimal(materialInfo[2]);
            
            materials.put(material, new BigDecimal[] {costPerSqFt, laborCostPerSqFt});
        }
        sc.close();
    }

}
