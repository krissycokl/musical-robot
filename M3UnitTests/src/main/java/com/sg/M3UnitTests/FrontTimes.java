package com.sg.M3UnitTests;

public class FrontTimes {
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    public static String frontTimes(String str, int n) {
        String rep;
        if (str.length() < 3) {rep = str;}
        else {rep = str.substring(0, 3);}
        return StringTimes.stringTimes(rep,n);
    }

}
