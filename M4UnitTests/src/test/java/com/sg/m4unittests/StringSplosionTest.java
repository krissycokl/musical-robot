/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.StringSplosion.stringSplosion;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringSplosionTest {

    public StringSplosionTest() {
    }

    @Test
    public void testStringSplosion() {
        assertEquals(stringSplosion("batcave"),"bbabatbatcbatcabatcavbatcave");
        assertEquals(stringSplosion("hmm"),"hhmhmm");
    }

}