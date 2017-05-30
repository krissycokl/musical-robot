package com.sg.m4unittests;

public class LongInMiddle {
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    public static String longInMiddle(String a, String b) {
        if(a.length()>b.length()){
            return b+a+b;
        } else {
            return a+b+a;
        }
    }

}
