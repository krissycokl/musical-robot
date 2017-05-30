package com.sg.m4unittests;

public class EveryOther {
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public static String everyOther(String str) {
        String newStr = "";
        for (int i=0;i<str.length();i++){
            if (i%2 == 0){
                newStr+=str.charAt(i);
            }
        }
        
        return newStr;
    }

}
