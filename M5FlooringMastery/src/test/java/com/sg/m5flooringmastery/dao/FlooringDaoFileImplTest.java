/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringDaoFileImplTest {
    
    FlooringDao dao;
    Order testOrder;
    File f;

    public FlooringDaoFileImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("flooringDao",FlooringDao.class);
    }
    
    @Before
    public void before(){
        testOrder = new Order(1);
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCustomerName("Joe");
        testOrder.setDay(LocalDate.now());
        testOrder.setMaterial("Wood");
        testOrder.setLaborCostPerSqFt(BigDecimal.ONE);
        testOrder.setMaterialCostPerSqFt(BigDecimal.ONE);
        testOrder.setMaterialCost(BigDecimal.ONE);
        testOrder.setLaborCost(BigDecimal.ONE);
        testOrder.setState("IL");
        testOrder.setTaxAmount(BigDecimal.ONE);
        testOrder.setTaxRate(BigDecimal.ONE);
        testOrder.setTotalCost(BigDecimal.TEN);
        
        f = new File("OrderArchive/Orders_01011900.txt");
        f.delete();
    }

    @Test
    public void testAddAndGetOrder() {
        dao.addOrder(testOrder);
        assertEquals(testOrder,dao.getOrder(1));
    }

    @Test
    public void testRemoveOrder() {
        dao.addOrder(testOrder);
        dao.removeOrder(1);
        assertNull(dao.getOrder(1));
    }

//    @Test
//    public void testChangeOrderDay() {
//    }

    @Test
    public void testEditOrder() {
        dao.addOrder(testOrder);
        Order testOrder2 = dao.getOrder(1);
        testOrder2.setArea(BigDecimal.TEN);
        dao.editOrder(testOrder2);
        assertEquals(testOrder2, dao.getOrder(1));
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        LocalDate testDay = LocalDate.of(1900, Month.JANUARY, 1);
        dao.addOrder(testOrder);
        dao.save(testDay);
        dao.removeOrder(1);
        dao.load(testDay);
        Order o1 = dao.getOrder(1);
        Order o2 = testOrder;
        assertEquals(o1.getArea(),o2.getArea());
        assertEquals(o1.getOrderNum(),o2.getOrderNum());
        assertEquals(o1.getCustomerName(),o2.getCustomerName());
    }
}