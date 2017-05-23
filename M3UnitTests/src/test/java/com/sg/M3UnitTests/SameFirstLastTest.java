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

public class SameFirstLastTest {

    public SameFirstLastTest() {
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
    public void testSameFirstLast() {
        assertTrue(SameFirstLast.sameFirstLast(new int[] {1, 3, 4, 1}));
        assertFalse(SameFirstLast.sameFirstLast(new int[] {1, 3, 4, 7}));
    }
    
    @Test
    public void testSameFirstLastLen1() {
        assertTrue(SameFirstLast.sameFirstLast(new int[] {788}));
    }

}