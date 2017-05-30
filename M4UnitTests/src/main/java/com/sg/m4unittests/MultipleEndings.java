package com.sg.m4unittests;

public class MultipleEndings {
    // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    public static String multipleEndings(String str) {
        int len = str.length();
        String l2 = str.substring(len-2,len);
        return l2+l2+l2;
    }

}
