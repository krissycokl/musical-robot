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

public class SleepingInTest {

    public SleepingInTest() {
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
    public void testCanSleepInTT() {
        assertTrue(SleepingIn.canSleepIn(true, true));
    }
    
    @Test
    public void testCanSleepInTF() {
        assertFalse(SleepingIn.canSleepIn(true, false));
    }
    
    @Test
    public void testCanSleepInFT() {
        assertTrue(SleepingIn.canSleepIn(false, true));
    }
    
    @Test
    public void testCanSleepInFF() {
        assertTrue(SleepingIn.canSleepIn(false, false));
    }

}