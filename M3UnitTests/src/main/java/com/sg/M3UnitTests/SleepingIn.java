package com.sg.M3UnitTests;

public class SleepingIn {
    // The parameter weekday is true if it is a weekday, and the 
    // parameter vacation is true if we are on vacation. We sleep 
    // in if it is not a weekday or we're on vacation. Return true 
    // if we sleep in. 
    //
    // canSleepIn(false, false) -> true
    // canSleepIn(true, false) -> false
    // canSleepIn(false, true) -> true
    public static boolean canSleepIn(boolean isWeekday, boolean isVacation) {
        if(isWeekday && !isVacation){
            return false;
        }
        return true;
    }

}
