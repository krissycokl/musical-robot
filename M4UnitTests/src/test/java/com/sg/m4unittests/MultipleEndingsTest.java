/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.MultipleEndings.multipleEndings;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultipleEndingsTest {

    public MultipleEndingsTest() {
    }

    @Test
    public void testMultipleEndings() {
        assertEquals(multipleEndings("kombucha"),"hahaha");
        assertEquals(multipleEndings("locusts"),"tststs");
        assertEquals(multipleEndings("hm"),"hmhmhm");
    }

}