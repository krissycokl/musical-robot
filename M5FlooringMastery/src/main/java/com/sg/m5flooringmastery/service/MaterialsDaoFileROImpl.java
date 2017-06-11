package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.dao.MaterialsDao;
import com.sg.m5flooringmastery.dao.MaterialsPersistenceException;
import com.sg.m5flooringmastery.model.Material;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaterialsDaoFileROImpl implements MaterialsDao {

    Map<String, Material> materials = new HashMap<>();
    
    public MaterialsDaoFileROImpl() throws FileNotFoundException{
        load();
    }

    @Override
    public void addMaterial(Material material) throws MaterialsPersistenceException {
        materials.put(material.getName(), material);
    }

    @Override
    public void editMaterial(Material oldMat, Material newMat) throws MaterialsPersistenceException {
        materials.remove(oldMat.getName());
        materials.put(newMat.getName(), newMat);
    }
    
    @Override
    public void removeMaterial(String name) throws MaterialsPersistenceException{
        materials.remove(name);
    }
    
    @Override
    public BigDecimal getMaterialCostPerSqFt(String material) {
        return materials.get(material).getMaterialCost();
    }
    
    @Override
    public BigDecimal getLaborCostPerSqFt(String material) {
        return materials.get(material).getLaborCost();
    }

    @Override
    public List<Material> getMaterialsList() {
        return materials.values().stream().collect(Collectors.toList());
    }
    
    void load() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Products.txt")));
        sc.nextLine();
        while(sc.hasNextLine()){
            Material newMat = new Material();
            String[] materialInfo = sc.nextLine().split(",");
            newMat.setName(materialInfo[0]);
            newMat.setMaterialCost(new BigDecimal(materialInfo[1]));
            newMat.setLaborCost(new BigDecimal(materialInfo[2]));
            
            materials.put(newMat.getName(), newMat);
        }
        sc.close();
    }

    @Override
    public Material getMaterial(String name){
        return materials.get(name);
    }
}