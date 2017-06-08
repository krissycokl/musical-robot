package com.sg.m5flooringmastery.service;

import com.sg.m5flooringmastery.model.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringServiceImplTest {

    private FlooringService service;
    
    public FlooringServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service",FlooringService.class);
    }

    @Test
    public void testGetDatesWithOrders() {
    }

    @Test
    public void testGetValidMaterials() {
        assertEquals(service.getValidMaterials().get(0),"Wood");
    }

    @Test
    public void testGetValidStates() {
        assertEquals(service.getValidStates().get(0),"IL");
    }

    @Test
    public void testAddOrder() throws Exception {
        Order testOrder = new Order(3);
        fail();
    }

    @Test
    public void testChangeOrderDay() throws Exception {
    }

    @Test
    public void testEditOrder() throws Exception {
    }

    @Test
    public void testGetOrder() throws Exception {
    }

    @Test
    public void testGetOrderMap() {
    }

    @Test
    public void testRemoveOrder() throws Exception {
    }

    @Test
    public void testLoadKey() throws Exception {
    }

    @Test
    public void testSaveKey() throws Exception {
    }

    @Test
    public void testValidateOrder() throws Exception {
        Order testOrder = new Order();
        
        try{
            service.validateOrder(testOrder);
            fail();
        } catch (InvalidOrderException ex){
        }
        
        testOrder.setArea(BigDecimal.ONE);
        
        try{
            service.validateOrder(testOrder);
            fail();
        } catch (InvalidOrderException ex){
        }
        
        testOrder.setCustomerName("Lois");
        testOrder.setDay(LocalDate.now());
        testOrder.setKey(1);
        testOrder.setMaterial("Wood");
        testOrder.setState("IL");
        
        assertTrue(service.validateOrder(testOrder));
    }

    @Test
    public void testRetrieveCosts() throws Exception {
        Order testOrder = new Order();
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCustomerName("Lois");
        testOrder.setDay(LocalDate.now());
        testOrder.setKey(1);
        testOrder.setMaterial("Wood");
        testOrder.setState("IL");
        
        assertNull(testOrder.getLaborCostPerSqFt());
        service.retrieveCosts(testOrder);
        assertEquals(testOrder.getLaborCostPerSqFt().compareTo(BigDecimal.ONE),0);
    }

    @Test
    public void testRetrieveTaxRate() throws Exception {
        Order testOrder = new Order();
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCustomerName("Lois");
        testOrder.setDay(LocalDate.now());
        testOrder.setKey(1);
        testOrder.setMaterial("Wood");
        testOrder.setState("IL");
        
        assertNull(testOrder.getTaxRate());
        service.retrieveTaxRate(testOrder);
        assertEquals(testOrder.getTaxRate().compareTo(new BigDecimal("5")),0);
    }

    @Test
    public void testCalculateCosts() throws Exception{
        Order testOrder = new Order();
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCustomerName("Lois");
        testOrder.setDay(LocalDate.now());
        testOrder.setKey(1);
        testOrder.setMaterial("Wood");
        testOrder.setState("IL");
        
        assertNull(testOrder.getTaxRate());
        service.retrieveTaxRate(testOrder);
        service.retrieveCosts(testOrder);
        service.calculateCosts(testOrder);
        assertEquals(testOrder.getTotalCost().compareTo(new BigDecimal("12")),0);
    }

}