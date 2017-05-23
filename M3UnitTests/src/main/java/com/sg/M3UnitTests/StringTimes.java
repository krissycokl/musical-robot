package com.sg.M3UnitTests;

public class StringTimes {
    public static String stringTimes(String str, int reps){
        if (reps==1) {return str;}
        return str+stringTimes(str, reps-1);
    }
}
