/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.m4unittests;

import static com.sg.m4unittests.InsertWord.insertWord;
import org.junit.Test;
import static org.junit.Assert.*;

public class InsertWordTest {

    public InsertWordTest() {
    }

    @Test
    public void testInsertWord() {
        assertEquals(insertWord("&&&&","garbage"),"&&garbage&&");
        assertEquals(insertWord("^~~^","meow"),"^~meow~^");
    }

}