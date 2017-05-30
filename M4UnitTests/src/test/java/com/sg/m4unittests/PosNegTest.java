/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.PosNeg.posNeg;
import org.junit.Test;
import static org.junit.Assert.*;

public class PosNegTest {

    public PosNegTest() {
    }

    @Test
    public void testPosNeg() {
        assertFalse(posNeg(1,1,false));
        assertFalse(posNeg(-1,200,true));
        assertTrue(posNeg(60,-60,false));
        assertTrue(posNeg(-10,-3,true));
    }

}