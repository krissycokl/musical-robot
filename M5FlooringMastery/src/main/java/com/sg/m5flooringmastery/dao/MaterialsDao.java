package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Material;
import java.math.BigDecimal;
import java.util.List;

public interface MaterialsDao {
    
    public BigDecimal getMaterialCostPerSqFt(String material);
    public BigDecimal getLaborCostPerSqFt(String material);
    public List<Material> getMaterialsList();
    
    /**
     * Add a new material
     * @param material
     * @throws com.sg.m5flooringmastery.dao.MaterialsPersistenceException
     */
    public void addMaterial(Material material) throws MaterialsPersistenceException;
    
    /**
     * Edit an existing material
     * @param oldMat
     * @param newMat
     * @throws com.sg.m5flooringmastery.dao.MaterialsPersistenceException
     */
    public void editMaterial(Material oldMat, Material newMat) throws MaterialsPersistenceException;
    
    /**
     * Remove an existing material
     * @param name 
     * @throws com.sg.m5flooringmastery.dao.MaterialsPersistenceException 
     */
    public void removeMaterial(String name) throws MaterialsPersistenceException;
    
    public Material getMaterial(String name);
}
