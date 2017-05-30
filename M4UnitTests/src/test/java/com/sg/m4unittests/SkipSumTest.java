/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.SkipSum.skipSum;
import org.junit.Test;
import static org.junit.Assert.*;

public class SkipSumTest {

    public SkipSumTest() {
    }

    @Test
    public void testSkipSum() {
        assertEquals(skipSum(5,13),20);
        assertEquals(skipSum(10,19),29);
        assertEquals(skipSum(3,4),7);
    }

}