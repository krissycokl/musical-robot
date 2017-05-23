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

public class MischievousChildrenTest {

    public MischievousChildrenTest() {
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
    public void testTroubleBothSmile(){
        assertEquals(MischievousChildren.areWeInTrouble(true, true),true);
    }
    
    @Test
    public void testTroubleNeitherSmile(){
        assertEquals(MischievousChildren.areWeInTrouble(false, false),true);
    }
    
    @Test
    public void testASmile(){
        assertEquals(MischievousChildren.areWeInTrouble(true, false),false);
    }
    
    @Test
    public void testBSmile(){
        assertEquals(MischievousChildren.areWeInTrouble(false, true),false);
    }

}