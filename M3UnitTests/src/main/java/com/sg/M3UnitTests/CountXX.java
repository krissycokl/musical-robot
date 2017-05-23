package com.sg.M3UnitTests;

public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public static int countXX(String str) {
        int count = 0;
        String[] letters = str.split("");
        
        for (int i = 0; i<(letters.length-1); i++){
            if (letters[i].equalsIgnoreCase("x")){
                if (letters[i+1].equalsIgnoreCase("x")){
                    count++;
                }
            }
        }
        
        return count;
    }

}
