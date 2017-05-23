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

public class CanHasTableTest {

    public CanHasTableTest() {
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
    public void testNeitherStylish() {
        assertEquals(CanHasTable.canHazTable(1, 1),0);
    }
    
    @Test
    public void testOnTheCuspOfStylish(){
        assertEquals(CanHasTable.canHazTable(2,3),0);
    }
    
    @Test
    public void testOnTheCuspOfNotStylish(){
        assertEquals(CanHasTable.canHazTable(3, 3),1);
    }
    
    @Test
    public void testVeryStylishAndNot(){
        assertEquals(CanHasTable.canHazTable(8, 1),2);
    }
    
    @Test
    public void testVeryStylishBoth(){
        assertEquals(CanHasTable.canHazTable(10, 10),2);
    }
    
    @Test
    public void testMiddlingBoth(){
        assertEquals(CanHasTable.canHazTable(5, 6),1);
    }

}