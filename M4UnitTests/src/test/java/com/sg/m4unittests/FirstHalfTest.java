/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.FirstHalf.firstHalf;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstHalfTest {

    public FirstHalfTest() {
    }

    @Test
    public void testFirstHalf() {
        assertEquals(firstHalf("bologna"),"bol");
        assertEquals(firstHalf("TeeHee"),"Tee");
        assertEquals(firstHalf("O"),"");
    }

}