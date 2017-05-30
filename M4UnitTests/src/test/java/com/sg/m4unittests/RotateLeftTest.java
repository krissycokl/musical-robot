/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.RotateLeft.rotateLeft;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotateLeftTest {

    public RotateLeftTest() {
    }

    @Test
    public void testRotateLeft() {
        assertArrayEquals(rotateLeft(new int[] {1,2,3}),new int[] {2, 3, 1});
        assertArrayEquals(rotateLeft(new int[] {1}),new int[] {1});
        assertArrayEquals(rotateLeft(new int[] {-1,3,4,2}),new int[] {3,4,2,-1});
    }

}