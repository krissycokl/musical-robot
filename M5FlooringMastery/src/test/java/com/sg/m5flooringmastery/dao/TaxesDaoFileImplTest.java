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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaxesDaoFileImplTest {

    TaxesDao dao;
    
    public TaxesDaoFileImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("taxesDao", TaxesDao.class);
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
    public void testGetRate() {
        assertEquals(dao.getRate("OH").compareTo(new BigDecimal(".0625")),0);
    }
}