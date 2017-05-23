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

public class MakeTagsTest {

    public MakeTagsTest() {
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
    public void testMakeTags() {
        assertEquals(MakeTags.makeTags("i", "make me italic"),"<i>make me italic</i>");
    }
    
    @Test
    public void testMakeTagsEmptyString(){
        assertEquals(MakeTags.makeTags("", "do WHAAAT?!"),"<>do WHAAAT?!</>");
    }

}