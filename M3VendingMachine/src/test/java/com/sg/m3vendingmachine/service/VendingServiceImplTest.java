/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m3vendingmachine.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendingServiceImplTest {

    private VendingService service;
    
    public VendingServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service",VendingService.class);
    }
    
    @Before
    public void setUp() throws FileNotFoundException{
        service.loadStock();
    }

    @After
    public void tearDown() throws IOException {
        service.saveStock();
    }

    @Test
    public void testAddItem() {
        int key = service.addItem();
        assertEquals(2, key);
    }

    @Test
    public void testChangeAndGetBalance() throws Exception {
        BigDecimal currBal = service.getBalance();
        BigDecimal add = BigDecimal.ONE;
        service.changeBalance(add);
        assertTrue(currBal.add(add).compareTo(service.getBalance()) == 0);
        
        try{
            service.changeBalance(BigDecimal.TEN);
            fail();
        } catch (FullOfMoneyException e) {
        }
    }

    @Test
    public void testAddAndGetStock() {
        int tempQty = service.getItem(1).getQty();
        service.addStock(1,1);
        assertEquals(tempQty+1,service.getItem(1).getQty());
    }

    @Test
    public void testGetItem() {
        assertEquals("Test Item 1",service.getItem(1).getName());
    }

    @Test
    public void testDecStock() {
        int tempQty = service.getItem(1).getQty();
        service.decStock(1);
        assertEquals(tempQty-1,service.getItem(1).getQty());
    }

    @Test
    public void testMakeChange() throws FullOfMoneyException{
        service.changeBalance(new BigDecimal("1.41"));
        BigDecimal one = BigDecimal.ONE.setScale(0);
        BigDecimal[] expectedChange = new BigDecimal[]{one, one, one, one};
        assertArrayEquals(expectedChange, service.makeChange(service.getItem(1).getCost()));
    }

    @Test
    public void testToggleActive() throws Exception {
        boolean currentStatus = service.getItem(1).getActive();
        service.toggleActive(1);
        assertNotEquals(currentStatus, service.getItem(1).getActive());
    }

    @Test
    public void testBuy() throws Exception {
        int tempQty = service.getItem(1).getQty();
        
        try {
            service.buy(1);
            fail();
        } catch (InsufficientFundsException e) {
            assertEquals(tempQty,service.getItem(1).getQty());
        }
        
        service.changeBalance(BigDecimal.ONE);
        service.buy(1);
        assertEquals(tempQty-1,service.getItem(1).getQty());
        
        try {
            service.buy(1);
            fail();
        } catch (ItemOutOfStockException e) {
            assertEquals(0,service.getItem(1).getQty());
        }
    }

}