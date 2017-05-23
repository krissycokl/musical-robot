/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.M3UnitTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MakePITest {

    public MakePITest() {
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
    public void testMakePi3() {
        Assert.assertArrayEquals(MakePI.makePi(3),new int[] {3,1,4});
    }
    
    @Test
    public void testMakePi5() {
        Assert.assertArrayEquals(new int[] {3,1,4,1,5}, MakePI.makePi(5));
    }
    
    @Test
    public void testMakePi1(){
        Assert.assertArrayEquals(new int[] {3}, MakePI.makePi(1));
    }

}