/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.LongInMiddle.longInMiddle;
import org.junit.Test;
import static org.junit.Assert.*;

public class LongInMiddleTest {

    public LongInMiddleTest() {
    }

    @Test
    public void testLongInMiddle() {
        assertEquals(longInMiddle("broccoli","basin"),"basinbroccolibasin");
        assertEquals(longInMiddle("lo","ALWAYSIO"),"loALWAYSIOlo");
        assertEquals(longInMiddle("hi",""),"hi");
    }

}