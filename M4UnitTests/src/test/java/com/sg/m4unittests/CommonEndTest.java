/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.CommonEnd.commonEnd;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommonEndTest {

    public CommonEndTest() {
    }

    @Test
    public void testCommonEnd() {
        assertTrue(commonEnd(new int[] {1}, new int[] {1}));
        assertTrue(commonEnd(new int[] {3,2,1}, new int[] {11,2,1}));
        assertFalse(commonEnd(new int[] {5,4,0}, new int[] {0,4,5}));
    }

}