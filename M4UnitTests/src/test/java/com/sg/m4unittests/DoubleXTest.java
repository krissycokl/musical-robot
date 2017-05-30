/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.DoubleX.doubleX;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleXTest {

    public DoubleXTest() {
    }

    @Test
    public void testDoubleXNotFirst() {
        assertFalse(doubleX("dxdddxx"));
    }
    
    @Test
    public void testDoubleXFirst() {
        assertTrue(doubleX("xxdgxrg"));
    }
    
    @Test
    public void testDoubleXAllXs(){
        assertTrue(doubleX("xxxxx"));
    }

}