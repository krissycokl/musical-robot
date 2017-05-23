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

public class Diff21Test {

    public Diff21Test() {
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
    public void testDiff21() {
        assertEquals(Diff21.diff21(21),0);
    }
    
    @Test
    public void testDiff22(){
        assertEquals(Diff21.diff21(22),2);
    }
    
    @Test
    public void testDiff2(){
        assertEquals(Diff21.diff21(2),19);
    }
    
    @Test
    public void testDiffNeg24(){
        assertEquals(Diff21.diff21(-24),45);
    }

}