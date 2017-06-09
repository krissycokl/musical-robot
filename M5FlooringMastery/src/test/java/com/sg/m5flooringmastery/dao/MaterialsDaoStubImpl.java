package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Material;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaterialsDaoStubImpl implements MaterialsDao {

    @Override
    public void addMaterial(Material material) throws MaterialsPersistenceException {
        // trust me, it's added
    }

    @Override
    public void editMaterial(Material oldMat, Material newMat) throws MaterialsPersistenceException {
        // trust me, it's edited
    }

    @Override
    public BigDecimal getLaborCostPerSqFt(String material) {
        return BigDecimal.ONE;
    }

    @Override
    public Material getMaterial(String name) {
        Material testMat = new Material();
        testMat.setName("Wood");
        testMat.setLaborCost(BigDecimal.ONE);
        testMat.setMaterialCost(BigDecimal.ONE);
        return testMat;
    }

    @Override
    public BigDecimal getMaterialCostPerSqFt(String material) {
        return BigDecimal.ONE;
    }

    @Override
    public List<Material> getMaterialsList() {
        List<Material> materials = new ArrayList<>();
        Material testMat = new Material();
        testMat.setName("Wood");
        testMat.setLaborCost(BigDecimal.ONE);
        testMat.setMaterialCost(BigDecimal.ONE);
        materials.add(testMat);
        return materials;
    }

    @Override
    public void removeMaterial(String name) throws MaterialsPersistenceException {
        // trust me, it's removed
    }

}
