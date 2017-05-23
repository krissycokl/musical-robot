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

public class AbbaTest {

    public AbbaTest() {
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
    public void testAbbaBothEmpty(){
        assertEquals("",Abba.abba("",""));
    }
    
    @Test
    public void testAbbaBothValid(){
        assertEquals("haveAAhave",Abba.abba("have","A"));
    }
    
    @Test
    public void testAbbaFirstEmpty(){
        assertEquals("wordword",Abba.abba("","word"));
    }
    
    @Test
    public void testAbbsSecondEmpty(){
        assertEquals("wordword",Abba.abba("word", ""));
    }
    
    @Test
    public void testNullValue(){
        try{
            assertEquals("null33null",Abba.abba(null,"3"));
        } catch (NullPointerException e) {
            fail("Should not have an error? For some reason?  Concat null ok?");
        }
    }

}