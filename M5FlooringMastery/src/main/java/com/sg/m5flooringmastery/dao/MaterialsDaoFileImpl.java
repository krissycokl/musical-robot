package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Material;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaterialsDaoFileImpl implements MaterialsDao {

    Map<String, Material> materials = new HashMap<>();
    
    private static final String[] MATERIALHEADER = {
        "ProductType",
        "CostPerSquareFoot",
        "LaborCostPerSquareFoot"
    };
    
    public MaterialsDaoFileImpl() throws FileNotFoundException{
        load();
    }

    @Override
    public void addMaterial(Material material) throws MaterialsPersistenceException {
        materials.put(material.getName(), material);
        try {
            save();
        } catch (IOException ex) {
            throw new MaterialsPersistenceException("Failed to save materials file.");
        }
    }

    @Override
    public void editMaterial(Material oldMat, Material newMat) throws MaterialsPersistenceException {
        materials.remove(oldMat.getName());
        materials.put(newMat.getName(), newMat);
        try {
            save();
        } catch (IOException ex) {
            throw new MaterialsPersistenceException("Failed to save materials file.");
        }
    }
    
    @Override
    public void removeMaterial(String name) throws MaterialsPersistenceException{
        materials.remove(name);
        try {
            save();
        } catch (IOException ex) {
            throw new MaterialsPersistenceException("Failed to save materials file.");
        }
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
    
    private void save() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("Products.txt", false));
        for (String s : MATERIALHEADER){
            out.print(s+",");
            out.flush();
        }
        out.print("\n");
        materials.entrySet().stream().forEach(e->{
            out.print(e.getKey()+",");
            out.print(e.getValue().getMaterialCost()+",");
            out.print(e.getValue().getLaborCost()+"\n");
            out.flush();
        });
        out.close();
    }

    @Override
    public Material getMaterial(String name){
        return materials.get(name);
    }
}