/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.EveryOther.everyOther;
import org.junit.Test;
import static org.junit.Assert.*;

public class EveryOtherTest {

    public EveryOtherTest() {
    }

    @Test
    public void testEveryOther() {
        assertEquals(everyOther("lololol"),"llll");
        assertEquals(everyOther("NEEDLES"),"NELS");
        assertEquals(everyOther("aaa"),"aa");
    }

}