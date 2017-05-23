package com.sg.M3UnitTests;

public class PlayOutside {
    // The children in Cleveland spend most of the day playing outside. 
    // In particular, they play if the temperature is between 60 and 90 
    // (inclusive). Unless it is summer, then the upper limit is 100 
    // instead of 90. Given an int temperature and a boolean isSummer, 
    // return true if the children play and false otherwise. 
    //
    // playOutside(70, false) → true
    // playOutside(95, false) → false
    // playOutside(95, true) → true
    public static boolean playOutside(int temp, boolean isSummer) {
        if (temp>=60){
            if (isSummer){
                if (temp<=100){
                    return true;
                }
            }
            if (temp<=90){
                return true;
            }
        }
        
        return false;
    }

}
