/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m5flooringmastery.dao;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MaterialsDaoFileImplTest {
    
    MaterialsDaoFileImpl dao;
    
    public MaterialsDaoFileImplTest() throws FileNotFoundException {
        this.dao = new MaterialsDaoFileImpl();
    }

    @Before
    public void before(){
        try{
            dao.load();
        } catch (FileNotFoundException e) {
            fail();
        }
    }
    
    @Test
    public void testGetMaterialCostPerSqFt() {
        assertEquals(dao.getMaterialCostPerSqFt("Wood").compareTo(new BigDecimal("5.15")),0);
    }

    @Test
    public void testGetLaborCostPerSqFt() {
        assertEquals(dao.getLaborCostPerSqFt("Laminate").compareTo(new BigDecimal("2.10")),0);
    }
}