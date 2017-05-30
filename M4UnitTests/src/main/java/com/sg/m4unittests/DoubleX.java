package com.sg.m4unittests;

public class DoubleX {
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public static boolean doubleX(String str) {
        int firstX = str.indexOf("x");
        return str.substring(firstX+1, firstX+2).equals("x");
    }
}
