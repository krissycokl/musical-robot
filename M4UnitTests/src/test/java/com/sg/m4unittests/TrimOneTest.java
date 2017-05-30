/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.TrimOne.trimOne;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrimOneTest {

    public TrimOneTest() {
    }

    @Test
    public void testTrimOne() {
        assertEquals(trimOne("Kristen"),"riste");
        assertEquals(trimOne("hm"),"");
    }

}