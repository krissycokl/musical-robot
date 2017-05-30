package com.sg.m4unittests;

public class StringSplosion {
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public static String stringSplosion(String str) {
        String tempStr = "";
        int len = str.length();
        for (int i=1; i<=len; i++){
            tempStr += str.substring(0,i);
        }
        return tempStr;
    }

}
