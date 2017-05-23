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

public class ParrotTroubleTest {

    public ParrotTroubleTest() {
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
    public void testParrotTroubleEarlyHours() {
        assertTrue(ParrotTrouble.parrotTrouble(true, 6));
        assertFalse(ParrotTrouble.parrotTrouble(false, 6));
    }
    
    @Test
    public void testParrotTroubleNormalHours() {
        assertFalse(ParrotTrouble.parrotTrouble(true,11));
        assertFalse(ParrotTrouble.parrotTrouble(false,11));
    }
    
    @Test
    public void testParrotTroubleLateHours() {
        assertTrue(ParrotTrouble.parrotTrouble(true, 21));
        assertFalse(ParrotTrouble.parrotTrouble(false, 21));
    }

}