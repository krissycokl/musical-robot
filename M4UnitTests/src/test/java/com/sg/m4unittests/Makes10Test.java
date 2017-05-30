/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.Makes10.makes10;
import org.junit.Test;
import static org.junit.Assert.*;

public class Makes10Test {

    public Makes10Test() {
    }

    @Test
    public void testMakes10() {
        assertTrue(makes10(5,5));
        assertTrue(makes10(10,5343));
        assertTrue(makes10(-500,510));
        assertFalse(makes10(5,6));
    }

}