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

public class PlayOutsideTest {

    public PlayOutsideTest() {
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
    public void testPlayOutsideNotSummer() {
        assertEquals(PlayOutside.playOutside(60, false),true);
        assertEquals(PlayOutside.playOutside(59, false),false);
        assertEquals(PlayOutside.playOutside(90, false),true);
        assertEquals(PlayOutside.playOutside(91, false),false);
    }
    
    @Test
    public void testPlayOutSideSummer(){
        assertEquals(PlayOutside.playOutside(60, true),true);
        assertEquals(PlayOutside.playOutside(59, true),false);
        assertEquals(PlayOutside.playOutside(90, true),true);
        assertEquals(PlayOutside.playOutside(91, true),true);
        assertEquals(PlayOutside.playOutside(101, true),false);
    }

}