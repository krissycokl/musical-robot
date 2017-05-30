/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.Sum.sum;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumTest {

    public SumTest() {
    }

    @Test
    public void testSum() {
        assertEquals(sum(new int[] {1,2,4}),7);
        assertEquals(sum(new int[] {-31}),-31);
    }

}