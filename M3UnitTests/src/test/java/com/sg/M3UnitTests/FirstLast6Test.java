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

public class FirstLast6Test {

    public FirstLast6Test() {
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
    public void testFirstLast6Len1() {
        assertTrue(FirstLast6.firstLast6(new int[]{6}));
        assertFalse(FirstLast6.firstLast6(new int[]{4}));
    }
    
    @Test
    public void testFirstLast6LongArray() {
        assertTrue(FirstLast6.firstLast6(new int[]{6, 5, -6, 1}));
        assertTrue(FirstLast6.firstLast6(new int[]{0,0,0,0, 5, -6, 6}));
        assertFalse(FirstLast6.firstLast6(new int[]{4,2,12,5,4-1,5,6-1}));
    }

}