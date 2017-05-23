/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.M3UnitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristen
 */
public class SayHiTest {
    
    private SayHi hi = new SayHi();
    
    public SayHiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSayHiMax() {
        assertEquals(hi.SayHi("Max"),"Hello, Max!");
    }
    
    @Test
    public void testSayHiAaron() {
        assertEquals(hi.SayHi("Aaron"),"Hello, Aaron!");
    }
    
    @Test
    public void testSayHiX(){
        assertEquals(hi.SayHi("X"),"Hello, X!");
    }
    
}
