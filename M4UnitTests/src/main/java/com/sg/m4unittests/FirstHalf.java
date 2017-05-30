package com.sg.m4unittests;

public class FirstHalf {
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    public static String firstHalf(String str) {
        int len = str.length()/2;
        return str.substring(0, len);
    }

}
