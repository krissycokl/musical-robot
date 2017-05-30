/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.CaughtSpeeding.caughtSpeeding;
import org.junit.Test;
import static org.junit.Assert.*;

public class CaughtSpeedingTest {

    @Test
    public void testCaughtSpeeding65() {
        assertEquals(caughtSpeeding(65,false),1);
        assertEquals(caughtSpeeding(65,true),0);
    }

    @Test
    public void testCaughtSpeeding81(){
        assertEquals(caughtSpeeding(81,false),2);
        assertEquals(caughtSpeeding(81,true),1);
    }
    
    @Test
    public void testCaughtSpeeding60(){
        assertEquals(caughtSpeeding(60,false),0);
        assertEquals(caughtSpeeding(60,true),0);
    }
    
}