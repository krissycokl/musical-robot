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

public class FrontTimesTest {

    public FrontTimesTest() {
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
    public void testFrontTimesMoney() {
        assertEquals(FrontTimes.frontTimes("money", 4),"monmonmonmon");
    }
    
    @Test
    public void testFrontTimesLessThan3Chars(){
        assertEquals(FrontTimes.frontTimes("an",3),"ananan");
    }
    
    @Test
    public void testFrontTimesCaps(){
        assertEquals(FrontTimes.frontTimes("hII",2),"hIIhII");
    }

}