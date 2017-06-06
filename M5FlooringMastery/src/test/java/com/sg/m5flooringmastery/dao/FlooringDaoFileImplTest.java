/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m5flooringmastery.dao;

import com.sg.m5flooringmastery.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringDaoFileImplTest {
    
    FlooringDao dao;
    Order testOrder;

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
        testOrder.setLaborCostPerSqFt(BigDecimal.ONE);
        testOrder.setMaterialCostPerSqFt(BigDecimal.ONE);
        testOrder.setMaterialCost(BigDecimal.ONE);
        testOrder.setLaborCost(BigDecimal.ONE);
        testOrder.setState("IL");
        testOrder.setTaxAmount(BigDecimal.ONE);
        testOrder.setTaxRate(BigDecimal.ONE);
        testOrder.setTotalCost(BigDecimal.TEN);
    }

    @Test
    public void testAddAndGetOrder() {
        dao.addOrder(testOrder);
        assertEquals(testOrder,dao.getOrder(1));
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

    //@Test
    //public void testLoad() throws Exception {
    //}

    @Test
    public void testRemoveOrder() {
        dao.addOrder(testOrder);
        dao.removeOrder(1);
        assertNull(dao.getOrder(1));
    }

    //@Test
    //public void testSave() throws Exception {
    //}

}