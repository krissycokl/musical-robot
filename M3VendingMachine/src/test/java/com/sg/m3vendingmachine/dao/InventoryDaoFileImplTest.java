/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m3vendingmachine.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoFileImplTest {
    
    private InventoryDao dao;
    
    public InventoryDaoFileImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dao", InventoryDao.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        dao.loadStock();
    }
    
    @Test
    public void testSetAndGetBalance() {
        BigDecimal tempBal = dao.getBalance();
        BigDecimal  change = new BigDecimal("5");
        dao.changeBalance(change);
        assertEquals(dao.getBalance().subtract(change),tempBal);
    }

    @Test
    public void testAddItem() {
        int itemID = dao.addItem();
        assertNotNull(dao.getItem(itemID));
    }

    @Test
    public void testAddAndGetStock() {
        int tempQty = dao.getItem(1).getQty();
        dao.addStock(1, 4);
        assertEquals(4, dao.getItem(1).getQty()-tempQty);
    }

    @Test
    public void testDecStock() {
        int tempQty = dao.getItem(1).getQty();
        dao.decStock(1);
        assertEquals(1, tempQty-dao.getItem(1).getQty());
    }

    @Test
    public void testToggleActive() {
        boolean tempActive = dao.getItem(1).getActive();
        dao.getItem(1).toggleActive();
        assertNotEquals(tempActive, dao.getItem(1).getActive());
    }

}