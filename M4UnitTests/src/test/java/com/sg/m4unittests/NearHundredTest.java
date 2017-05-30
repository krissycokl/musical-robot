/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.NearHundred.nearHundred;
import org.junit.Test;
import static org.junit.Assert.*;

public class NearHundredTest {

    public NearHundredTest() {
    }

    @Test
    public void testNearHundred() {
        assertTrue(nearHundred(100));
        assertTrue(nearHundred(210));
        assertFalse(nearHundred(111));
        assertFalse(nearHundred(189));
    }

}